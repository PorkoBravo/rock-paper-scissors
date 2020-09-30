package gz.porcobravo.rps.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import gz.porcobravo.rps.data.MatchHistoryDatabase;

@SpringBootTest
public class MatchHistoryDataService_Should {

	@Autowired
	private MatchHistoryDataService service;
	
	@MockBean
	private MatchHistoryDatabase mockedDatabase;
	
	@Test
	public void invoke_1_time_data_service() {
		when(mockedDatabase.getHistory()).thenReturn(null);

		this.service.getHistory();

		verify(mockedDatabase, times(1)).getHistory();
	}
}
