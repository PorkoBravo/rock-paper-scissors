package gz.porcobravo.rps.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import gz.porcobravo.dtos.MatchHistory;
import gz.porcobravo.rps.data.MatchHistoryData;
import gz.porcobravo.rps.mappers.MatchHistoryMapper;

@SpringBootTest
public class MatchHistoryService_Should {

	@Autowired
	private MatchHistoryService service;

	@MockBean
	private MatchHistoryDataService mockDataService;
	
	@MockBean
	private MatchHistoryMapper mapper;
	
	@BeforeEach
	public void setup() {
		when(mapper.fromEntity(ArgumentMatchers.any())).thenReturn(new MatchHistory());
	}

	@Test
	public void return_no_null() {
		when(mockDataService.getHistory()).thenReturn(null);

		MatchHistory result = this.service.getMatchHistoy();

		assertNotNull(result);
	}

	@Test
	public void invoke_1_time_data_service() {
		when(mockDataService.getHistory()).thenReturn(null);

		this.service.getMatchHistoy();

		verify(mockDataService, times(1)).getHistory();
	}

	@Test
	public void invoke_the_mapper_to_get_the_dto() {
		MatchHistoryData just_a_mocked_data = new MatchHistoryData(1, 2, 3, 4);
		when(mockDataService.getHistory()).thenReturn(just_a_mocked_data);

		this.service.getMatchHistoy();

		verify(mapper, times(1)).fromEntity(just_a_mocked_data);
	}

	@Test
	public void not_invoke_the_mapper_to_get_dto() {
		when(mockDataService.getHistory()).thenReturn(null);

		this.service.getMatchHistoy();

		verify(mapper, times(0)).fromEntity(ArgumentMatchers.any());
	}
}
