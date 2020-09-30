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

import gz.porcobravo.dtos.MatchHistory;
import gz.porcobravo.rps.controllers.MatchHistoryController;
import gz.porcobravo.rps.services.MatchHistoryService;

@WebMvcTest(controllers = MatchHistoryController.class)
public class MatchHistoryController_Should {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	MatchHistoryService mockService;

	private static final String REQUEST_MAPPING = "/history";
	
	@Test
	public void should_return_ok_on_get() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_MAPPING).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void should_invoke_service_1_time() throws Exception {
		when(mockService.getMatchHistoy()).thenReturn(new MatchHistory());
	
		mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_MAPPING).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		verify(mockService, times(1)).getMatchHistoy();
	}
	
}
