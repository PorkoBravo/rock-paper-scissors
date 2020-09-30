package gz.porcobravo.rps.data;

import org.springframework.stereotype.Component;

@Component
public class MatchHistoryDatabase {

	private Integer rounds = 0;
	private Integer winsForPlayer1 = 0;
	private Integer winsForPlayer2 = 0;
	private Integer draws = 0;

	public synchronized MatchHistoryData getHistory() {
		return new MatchHistoryData(rounds, winsForPlayer1, winsForPlayer2, draws);
	}

	public synchronized void saveDraw() {
		increaseTotalRounds();
		this.draws++;
	}

	public synchronized void saveWinForPlayer1() {
		increaseTotalRounds();
		this.winsForPlayer1++;
	}

	public synchronized void saveWinForPlayer2() {
		increaseTotalRounds();
		this.winsForPlayer2++;
	}
	
	private synchronized void increaseTotalRounds() {
		this.rounds++;
	}
}
