package gz.porcobravo.rps.services;

import gz.porcobravo.rps.data.MatchHistoryData;

public interface MatchHistoryDataService {

	public MatchHistoryData getHistory();
	public void saveDraw();
	public void savePlayer1Victory();
	public void savePlayer2Victory();
}
