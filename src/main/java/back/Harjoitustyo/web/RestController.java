package back.Harjoitustyo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import back.Harjoitustyo.domain.AppUser;
import back.Harjoitustyo.domain.AppUserRepository;
import back.Harjoitustyo.domain.Ruoka;
import back.Harjoitustyo.domain.RuokaRepository;
import back.Harjoitustyo.domain.Unenlaatu;
import back.Harjoitustyo.domain.UnenlaatuRepository;
import back.Harjoitustyo.domain.Uni;
import back.Harjoitustyo.domain.UniRepository;

@Controller
public class RestController {

	@Autowired
	RuokaRepository ruokaRepository;
	@Autowired
	UniRepository uniRepository;
	@Autowired
	UnenlaatuRepository unenlaatuRepository;
	@Autowired
	AppUserRepository appUserRepository;

	// Hae ja näytä kaikki ruoat
	@GetMapping("/restRuoat")
	public @ResponseBody List<Ruoka> showRestRuoat() {
		return ruokaRepository.findAll();
	}

	// Hae ja näytä kaikki unet
	@GetMapping("/restUnet")
	public @ResponseBody List<Uni> showRestUnet() {
		return (List<Uni>) uniRepository.findAll();
	}

	// Hae ja näytä kaikki unenlaadut
	@GetMapping("/restUnenlaadut")
	public @ResponseBody List<Unenlaatu> showRestUnenlaadut() {
		return (List<Unenlaatu>) unenlaatuRepository.findAll();
	}

	// Hae ja näytä kaikki userit
	@GetMapping("/restUserit")
	public @ResponseBody List<AppUser> showRestUserit() {
		return (List<AppUser>) appUserRepository.findAll();
	}

}