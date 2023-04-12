package back.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import back.Harjoitustyo.domain.AppUser;
import back.Harjoitustyo.domain.AppUserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AppUserRepositoryTests {
	@Autowired
	AppUserRepository appUserRepository;

	@Test
	public void etsiTunnus() {
		AppUser appUser = appUserRepository.findByUsername("user");
		assertThat(appUser.getUsername().equals("user"));
	}

	@Test
	public void uusiTunnus() {
		AppUser appUser = new AppUser("username", "salasana", "rooli");
		appUserRepository.save(appUser);
		assertNotEquals(appUser.getId(), null);
	}

	@Test
	public void poistaTunnus() {
		AppUser appUsers = appUserRepository.findByUsername("user");
		AppUser appUser = appUsers;

		appUserRepository.delete(appUser);

		AppUser newAppUsers = appUserRepository.findByUsername("user");
		assertThat(newAppUsers == null);

	}

}
