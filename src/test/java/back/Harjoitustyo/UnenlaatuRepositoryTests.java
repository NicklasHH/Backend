package back.Harjoitustyo;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import back.Harjoitustyo.domain.Unenlaatu;
import back.Harjoitustyo.domain.UnenlaatuRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UnenlaatuRepositoryTests {
	@Autowired
	UnenlaatuRepository unenlaatuRepository;

	@Test
	public void lisaaUnenlaatu() {
		Unenlaatu unenlaatu = new Unenlaatu("laatu");
		unenlaatuRepository.save(unenlaatu);
		assertNotEquals(unenlaatu.getId(), null);
	}

	@Test
	public void poistaUnenlaatu() {
		Unenlaatu unenlaatu = new Unenlaatu("laatu");
		unenlaatuRepository.save(unenlaatu);

		Long id = unenlaatu.getId();
		unenlaatuRepository.deleteById(id);

		Unenlaatu poistettuUnenlaatu = unenlaatuRepository.findById(id).orElse(null);
		assertNull(poistettuUnenlaatu);
	}

}
