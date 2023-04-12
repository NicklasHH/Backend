package back.Harjoitustyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.Harjoitustyo.domain.Ruoka;
import back.Harjoitustyo.domain.RuokaRepository;

@Service
public class RuokaService {
	@Autowired
	private RuokaRepository ruokaRepository;

	public List<Ruoka> listAll(String haku) {
		if (haku != null) {
			return ruokaRepository.hae(haku);
		}
		return ruokaRepository.findAll();
	}

}
