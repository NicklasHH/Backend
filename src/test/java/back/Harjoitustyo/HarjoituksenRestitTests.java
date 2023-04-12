package back.Harjoitustyo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class HarjoituksenRestitTests {

	@Autowired
	private WebApplicationContext webAppContext;

	private MockMvc mockMvc;

	@BeforeEach // JUnit5
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@Test
	public void testRe() throws Exception {
		mockMvc.perform(get("/restRuoat")).andExpect(status().isOk());
		mockMvc.perform(get("/restUnet")).andExpect(status().isOk());
		mockMvc.perform(get("/restUnenlaadut")).andExpect(status().isOk());
		mockMvc.perform(get("/restUserit")).andExpect(status().isOk());
	}

	@Test
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/restRuoat")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMvc.perform(get("/restUnet")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMvc.perform(get("/restUnenlaadut")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMvc.perform(get("/restUserit")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
