package gz.porcobravo.rps.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import gz.porcobravo.dtos.MatchHistory;

@SpringBootTest
public class MatchHistoryService_Should {

	@Autowired
	private MatchHistoryService service;
	
	@MockBean
	private MatchHistoryDataService mockDataService;
	
	@Test
	public void return_no_null() {
		when(mockDataService.getHistory()).thenReturn(null);
		
		MatchHistory result = this.service.getMatchHistoy();
		
		assertNotNull(result);
	}
}
