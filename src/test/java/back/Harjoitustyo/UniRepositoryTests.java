package back.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import back.Harjoitustyo.domain.Uni;
import back.Harjoitustyo.domain.UniRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UniRepositoryTests {
	@Autowired
	UniRepository uniRepository;

	@Test
	public void lisaaUni() {
		Uni uni = new Uni("5:00", "ei ole", "2023-03-20");
		uniRepository.save(uni);
		assertNotEquals(uni.getId(), null);
	}

	@Test
	public void etsiPvm() {
		List<Uni> uni = uniRepository.findByPvm("2023-03-20");
		assertThat(uni.get(0).getPvm().equals("2023-03-20"));
	}

	@Test
	public void poistaUni() {
		List<Uni> unet = uniRepository.findByPvm("2023-03-20");
		Uni uni = unet.get(0);

		uniRepository.delete(uni);

		List<Uni> uusiUni = uniRepository.findByPvm("2023-03-20");
		assertThat(uusiUni).hasSize(0);
	}

}
