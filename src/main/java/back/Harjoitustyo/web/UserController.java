package back.Harjoitustyo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import back.Harjoitustyo.domain.AppUser;
import back.Harjoitustyo.domain.AppUserRepository;
import back.Harjoitustyo.domain.UusiTunnus;

@Controller
public class UserController {
	@Autowired
	private AppUserRepository repository;

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("uusiTunnus")
	public String uusiTunnus(Model model) {
		model.addAttribute("uusiTunnus", new UusiTunnus());
		return "uusiTunnus";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "tallennaTunnus", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("uusiTunnus") UusiTunnus uusiTunnus, BindingResult bindingResult) {
		if (repository.findByUsername(uusiTunnus.getTunnus()) != null) {
			bindingResult.rejectValue("tunnus", "error.uusiTunnus", "Tunnus on jo olemassa");
			return "uusiTunnus";
		}

		if (bindingResult.hasErrors()) {
			return "uusiTunnus";
		}

		String salasana = uusiTunnus.getSalasana();
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		String hashSalasana = bc.encode(salasana);

		AppUser appUser = new AppUser();
		appUser.setPasswordHash(hashSalasana);
		appUser.setUsername(uusiTunnus.getTunnus());
		appUser.setRole(uusiTunnus.getRooli());
		repository.save(appUser);

		return "redirect:/onnistui";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("onnistui")
	public String tunnusLisatty() {
		return "tunnusLisatty";
	}

}