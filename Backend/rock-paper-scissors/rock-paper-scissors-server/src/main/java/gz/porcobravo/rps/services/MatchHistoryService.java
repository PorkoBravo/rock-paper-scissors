package gz.porcobravo.rps.services;

import gz.porcobravo.dtos.MatchHistory;

public interface MatchHistoryService {

	public MatchHistory getMatchHistoy();
	public void addDraw();
	public void addPlayer1Victory();
	public void addPlayer2Victory();
}
