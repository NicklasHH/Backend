package back.Harjoitustyo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import back.Harjoitustyo.domain.Ruoka;
import back.Harjoitustyo.domain.RuokaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RuokaRepositoryTests {
	@Autowired
	RuokaRepository ruokaRepository;

	@Test
	public void lisaaRuoka() {
		Ruoka ruoka = new Ruoka("nimi", "lisatietoja", "pvm", "kellonaika");
		ruokaRepository.save(ruoka);
		assertNotEquals(ruoka.getId(), null);
	}

	@Test
	public void poistaRuoka() {
		Ruoka ruoka = new Ruoka("nimi", "lisatietoja", "pvm", "kellonaika");
		ruokaRepository.save(ruoka);
		Long id = ruoka.getId();
		assertNotNull(id);

		ruokaRepository.delete(ruoka);

		Ruoka poistettuRuoka = ruokaRepository.findById(id).orElse(null);
		assertNull(poistettuRuoka);
	}

}
