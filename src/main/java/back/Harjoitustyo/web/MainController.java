package back.Harjoitustyo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import back.Harjoitustyo.domain.AppUserRepository;
import back.Harjoitustyo.domain.Ruoka;
import back.Harjoitustyo.domain.RuokaRepository;
import back.Harjoitustyo.domain.UnenlaatuRepository;
import back.Harjoitustyo.domain.Uni;
import back.Harjoitustyo.domain.UniRepository;
import back.Harjoitustyo.service.RuokaService;

@Controller
public class MainController {

	@Autowired
	RuokaRepository ruokaRepository;
	@Autowired
	UniRepository uniRepository;
	@Autowired
	UnenlaatuRepository unenlaatuRepository;
	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	RuokaService ruokaService;

	// etusivu
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	// sisäänkirjaus
	@GetMapping("/login")
	public String login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/";
	}

	// uni
	@RequestMapping("uni")
	public String uni(Model model) {
		model.addAttribute("unet", uniRepository.findAll());
		return "unenseuranta";
	}

	@GetMapping("uusiUni")
	public String uusiUni(Model model) {
		model.addAttribute("lisaaUni", new Uni());
		model.addAttribute("unenlaadut", unenlaatuRepository.findAll());
		return "uusiUni";
	}

	@PostMapping("tallennaUni")
	public String tallennaUni(Uni uni) {
		uniRepository.save(uni);
		return "redirect:/uni";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("muokkaaUni/{id}")
	public String muokkaaUni(@PathVariable("id") Long id, Model model) {
		model.addAttribute("muokkaaUni", uniRepository.findById(id));
		model.addAttribute("unenlaadut", unenlaatuRepository.findAll());
		return "muokkaaUni";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("poistaUni/{id}")
	public String poistaUni(@PathVariable("id") Long id) {
		uniRepository.deleteById(id);
		return "redirect:/uni";
	}

	// ruoka
	@RequestMapping("/ruoka")
	public String ruoka(Model model, @Param("haku") String haku) {
		List<Ruoka> ruoat = ruokaService.listAll(haku);
		model.addAttribute("ruoat", ruoat);
		model.addAttribute("haku", haku);

		return "ruokapaivakirja";
	}

	@GetMapping("uusiRuoka")
	public String uusiRuoka(Model model) {
		model.addAttribute("lisaaRuoka", new Ruoka());
		return "uusiRuoka";
	}

	@PostMapping("tallennaRuoka")
	public String tallennaRuoka(@Valid @ModelAttribute("lisaaRuoka") Ruoka ruoka, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("erroria pukkas");
			return "uusiRuoka";
		}
		ruokaRepository.save(ruoka);
		return "redirect:/ruoka";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("muokkaaRuoka/{id}")
	public String muokkaaRuoka(@PathVariable("id") Long id, Model model) {
		model.addAttribute("muokkaaRuoka", ruokaRepository.findById(id));
		return "muokkaaRuoka";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("poistaRuoka/{id}")
	public String poistaRuoka(@PathVariable("id") Long id) {
		ruokaRepository.deleteById(id);
		return "redirect:/ruoka";
	}

	// Virheet/käyttäjätunnuksen riittämättömyys
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleRuntimeException(Model model, RuntimeException ex) {
		model.addAttribute("virheViesti", ex.getMessage());
		System.out.println(ex.getMessage());
		return "error";
	}

}