package gz.porcobravo.rps.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import gz.porcobravo.dtos.MatchResult;
import gz.porcobravo.dtos.Result;
import gz.porcobravo.dtos.Shapes;
import gz.porcobravo.rps.components.GenerateRandomNumber;

@SpringBootTest
public class MatchService_Should {
	private final static Integer ROCK = 0;
	private final static Integer PAPER = 1;
	private final static Integer SCISSORS = 2;

	@Autowired
	MatchService service;

	@MockBean
	GenerateRandomNumber mockedRandomNumberGenerator;
	
	@MockBean
	Map<Integer, Result> mockedResultBean;
	
	@MockBean
	MatchHistoryDataService mockedHistoryDataService;


	@Test
	public void call_the_random_number_generator_1_time() {
		this.service.playNewMatch();

		verify(mockedRandomNumberGenerator, times(1)).generate(ArgumentMatchers.anyInt());
	}

	@Test
	public void call_the_random_number_generator_with_the_number_of_shapes_as_input() {
		this.service.playNewMatch();

		verify(mockedRandomNumberGenerator, times(1)).generate(Shapes.values().length);
	}

	@Test
	public void return_a_match_result() {
		MatchResult result = this.service.playNewMatch();
		assertNotNull(result);
	}

	@Test
	public void return_a_match_where_player2_shape_is_rock() {
		MatchResult result = this.service.playNewMatch();

		assertEquals(Shapes.ROCK, result.getPlayer2Shape());
	}

	@Test
	public void return_a_match_where_player1_shape_is_rock() {
		when(mockedRandomNumberGenerator.generate(ArgumentMatchers.anyInt())).thenReturn(ROCK);

		MatchResult result = this.service.playNewMatch();

		assertEquals(Shapes.ROCK, result.getPlayer1Shape());
	}

	@Test
	public void return_a_match_where_player1_shape_is_paper() {
		when(mockedRandomNumberGenerator.generate(ArgumentMatchers.anyInt())).thenReturn(PAPER);

		MatchResult result = this.service.playNewMatch();

		assertEquals(Shapes.PAPER, result.getPlayer1Shape());

	}

	@Test
	public void return_a_match_where_player1_shape_is_scissors() {
		when(mockedRandomNumberGenerator.generate(ArgumentMatchers.anyInt())).thenReturn(SCISSORS);

		MatchResult result = this.service.playNewMatch();

		assertEquals(Shapes.SCISSORS, result.getPlayer1Shape());
	}

	@Test
	public void return_a_draw_match() {
		when(mockedRandomNumberGenerator.generate(ArgumentMatchers.anyInt())).thenReturn(ROCK);
		when(mockedResultBean.get(ROCK)).thenReturn(Result.DRAW);

		MatchResult result = this.service.playNewMatch();

		assertEquals(Result.DRAW, result.getResult());
	}

	@Test
	public void return_player_2_as_winner() {
		when(mockedRandomNumberGenerator.generate(ArgumentMatchers.anyInt())).thenReturn(SCISSORS);
		when(mockedResultBean.get(SCISSORS)).thenReturn(Result.PLAYER_2_WIN);

		MatchResult result = this.service.playNewMatch();

		assertEquals(Result.PLAYER_2_WIN, result.getResult());
	}

	@Test
	public void return_player_1_as_winner() {
		when(mockedRandomNumberGenerator.generate(ArgumentMatchers.anyInt())).thenReturn(PAPER);
		when(mockedResultBean.get(PAPER)).thenReturn(Result.PLAYER_1_WIN);

		MatchResult result = this.service.playNewMatch();

		assertEquals(Result.PLAYER_1_WIN, result.getResult());
	}
	
	@Test
	public void retrieve_match_result_from_map() {
		this.service.playNewMatch();

		verify(mockedResultBean, times(1)).get(ROCK);
	}
	

	@Test
	public void invoke_match_history_service_adding_a_draw() {
		when(mockedRandomNumberGenerator.generate(ArgumentMatchers.anyInt())).thenReturn(0);
		when(mockedResultBean.get(ArgumentMatchers.anyInt())).thenReturn(Result.DRAW);
		
		this.service.playNewMatch();
		
		verify(mockedHistoryDataService, times(1)).saveDraw();
	}

	@Test
	public void invoke_match_history_service_adding_player_1_as_winner() {
		when(mockedRandomNumberGenerator.generate(ArgumentMatchers.anyInt())).thenReturn(0);
		when(mockedResultBean.get(ArgumentMatchers.anyInt())).thenReturn(Result.PLAYER_1_WIN);
		
		this.service.playNewMatch();
		
		verify(mockedHistoryDataService, times(1)).savePlayer1Victory();
	}
	
	@Test
	public void invoke_match_history_service_adding_player_2_as_winner() {
		when(mockedRandomNumberGenerator.generate(ArgumentMatchers.anyInt())).thenReturn(0);
		when(mockedResultBean.get(ArgumentMatchers.anyInt())).thenReturn(Result.PLAYER_2_WIN);
		
		this.service.playNewMatch();
		
		verify(mockedHistoryDataService, times(1)).savePlayer2Victory();
	}
}
