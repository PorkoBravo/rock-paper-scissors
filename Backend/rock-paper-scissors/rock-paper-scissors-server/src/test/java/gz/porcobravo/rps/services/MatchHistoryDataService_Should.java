package gz.porcobravo.rps.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
	public void invoke_1_time_data_service_when_get_history() {
		this.service.getHistory();

		verify(mockedDatabase, times(1)).getHistory();
	}
	
	@Test
	public void invoke_1_time_data_service_when_saving_draw() {
		this.service.saveDraw();

		verify(mockedDatabase, times(1)).saveDraw();
	}
	
	@Test
	public void invoke_1_time_data_service_when_saving_win_for_player_1() {
		this.service.savePlayer1Victory();

		verify(mockedDatabase, times(1)).saveWinForPlayer1();
	}
	
	@Test
	public void invoke_1_time_data_service_when_saving_win_for_player_2() {
		this.service.savePlayer2Victory();

		verify(mockedDatabase, times(1)).saveWinForPlayer2();
	}
}
