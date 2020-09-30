package gz.porcobravo.rps.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gz.porcobravo.rps.data.MatchHistoryData;
import gz.porcobravo.rps.data.MatchHistoryDatabase;
import gz.porcobravo.rps.services.MatchHistoryDataService;

@Service
public class MatchHistoryDataManager implements MatchHistoryDataService {
	
	@Autowired
	private MatchHistoryDatabase historyDatabase;

	@Override
	public MatchHistoryData getHistory() {
		// not yet
		return null;
	}

}
