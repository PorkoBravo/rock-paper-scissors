package gz.porcobravo.rps.components;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import gz.porcobravo.rps.data.MatchHistoryData;
import gz.porcobravo.rps.data.MatchHistoryDatabase;

@SpringBootTest(classes = MatchHistoryDatabase.class)
public class MatchHistoryDatabase_Should {
	
	@Autowired
	private MatchHistoryDatabase matchHistory;
	
	private final String ROUNDS_FIELD = "rounds";
	private final String WINS_PLAYER_1_FIELD = "winsForPlayer1";
	private final String WINS_PLAYER_2_FIELD = "winsForPlayer2";
	private final String DRAWS_FIELD = "draws";

	@Test
	public void return_match_history_object() {
		MatchHistoryData result = this.matchHistory.getHistory();
		assertNotNull(result);
	}
	
	@Test
	public void return_match_history_with_total_rounds() {
		final Integer total_rounds = 100;
		ReflectionTestUtils.setField(matchHistory, ROUNDS_FIELD, total_rounds);
		MatchHistoryData result = this.matchHistory.getHistory();
		assertEquals(total_rounds, result.getRounds());
	}
	
	@Test
	public void return_match_history_with_total_wins_player_1() {
		final Integer total_wins = 56;
		ReflectionTestUtils.setField(matchHistory, WINS_PLAYER_1_FIELD, total_wins);
		MatchHistoryData result = this.matchHistory.getHistory();
		assertEquals(total_wins, result.getWinsForPlayer1());
	}
	
	@Test
	public void return_match_history_with_total_wins_player_2() {
		final Integer total_wins = 34;
		ReflectionTestUtils.setField(matchHistory, WINS_PLAYER_2_FIELD, total_wins);
		MatchHistoryData result = this.matchHistory.getHistory();
		assertEquals(total_wins, result.getWinsForPlayer2());
	}
	
	@Test
	public void return_match_history_with_total_draws() {
		final Integer total_draws = 6;
		ReflectionTestUtils.setField(matchHistory, DRAWS_FIELD, total_draws);
		MatchHistoryData result = this.matchHistory.getHistory();
		assertEquals(total_draws, result.getDraws());
	}
	
	@Test
	public void increase_total_rounds_saving_draw() {
		final Integer initial_rounds = 0;
		ReflectionTestUtils.setField(matchHistory, ROUNDS_FIELD, initial_rounds);
		
		this.matchHistory.saveDraw();
		
		assertEquals(initial_rounds+1, ReflectionTestUtils.getField(matchHistory, ROUNDS_FIELD));
	}

	@Test
	public void increase_total_rounds_saving_player_1_victory() {
		final Integer initial_rounds = 0;
		ReflectionTestUtils.setField(matchHistory, ROUNDS_FIELD, initial_rounds);
		
		this.matchHistory.saveWinForPlayer1();
		
		assertEquals(initial_rounds+1, ReflectionTestUtils.getField(matchHistory, ROUNDS_FIELD));
	}
	
	@Test
	public void increase_total_rounds_saving_player_2_victory() {
		final Integer initial_rounds = 0;
		ReflectionTestUtils.setField(matchHistory, ROUNDS_FIELD, initial_rounds);
		
		this.matchHistory.saveWinForPlayer2();
		
		assertEquals(initial_rounds+1, ReflectionTestUtils.getField(matchHistory, ROUNDS_FIELD));
	}
	
	@Test
	public void increase_draws() {
		final Integer initial_draws = 0;
		ReflectionTestUtils.setField(matchHistory, DRAWS_FIELD, initial_draws);
		
		this.matchHistory.saveDraw();
		
		assertEquals(initial_draws+1, ReflectionTestUtils.getField(matchHistory, DRAWS_FIELD));
	}
	
	@Test
	public void increase_wins_for_player_1() {
		final Integer initial_victories = 0;
		ReflectionTestUtils.setField(matchHistory, WINS_PLAYER_1_FIELD, initial_victories);
		
		this.matchHistory.saveWinForPlayer1();
		
		assertEquals(initial_victories+1, ReflectionTestUtils.getField(matchHistory, WINS_PLAYER_1_FIELD));
	}
	
	@Test
	public void increase_wins_for_player_2() {
		final Integer initial_victories = 0;
		ReflectionTestUtils.setField(matchHistory, WINS_PLAYER_2_FIELD, initial_victories);
		
		this.matchHistory.saveWinForPlayer2();
		
		assertEquals(initial_victories+1, ReflectionTestUtils.getField(matchHistory, WINS_PLAYER_2_FIELD));
	}
}
