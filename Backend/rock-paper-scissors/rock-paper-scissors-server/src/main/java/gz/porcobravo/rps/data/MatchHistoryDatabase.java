package gz.porcobravo.rps.data;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class MatchHistoryDatabase {
	
	private @NotNull Integer rounds;
	private @NotNull Integer winsForPlayer1;
	private @NotNull Integer winsForPlayer2;
	private @NotNull Integer draws;
	
	public synchronized MatchHistoryData getHistory() {
		return new MatchHistoryData(rounds, winsForPlayer1, winsForPlayer2, draws);
	}
}
