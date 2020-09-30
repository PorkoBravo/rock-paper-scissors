package gz.porcobravo.rps.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import gz.porcobravo.rps.services.MatchService;

@WebMvcTest(controllers = MatchController.class)
public class MatchController_Should {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	MatchService mockedService;
	
	private static final String REQUEST_MAPPING = "/match";

	@Test
	public void should_return_ok_on_post() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(REQUEST_MAPPING).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void should_invoke_service_1_time() throws Exception {
		when(mockedService.playNewMatch()).thenReturn(null);
	
		mockMvc.perform(MockMvcRequestBuilders.post(REQUEST_MAPPING).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		verify(mockedService, times(1)).playNewMatch();
	}
}
