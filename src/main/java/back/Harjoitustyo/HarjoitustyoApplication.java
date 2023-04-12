package back.Harjoitustyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import back.Harjoitustyo.domain.RuokaRepository;

@SpringBootApplication
public class HarjoitustyoApplication {

	@Autowired
	RuokaRepository ruokaRepository;

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

}
