package gz.porcobravo.rps.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gz.porcobravo.dtos.MatchHistory;
import gz.porcobravo.rps.data.MatchHistoryData;
import gz.porcobravo.rps.mappers.MatchHistoryMapper;
import gz.porcobravo.rps.services.MatchHistoryDataService;
import gz.porcobravo.rps.services.MatchHistoryService;

@Service
public class MatchHistoryManager implements MatchHistoryService{
	
	@Autowired
	private MatchHistoryDataService dataService;
	
	@Autowired
	private MatchHistoryMapper mapper;

	@Override
	public MatchHistory getMatchHistoy() {
		MatchHistoryData matchHistoryData = dataService.getHistory();
		if(matchHistoryData != null) {
			return mapper.fromEntity(matchHistoryData);
		}
		return new MatchHistory();
	}

	@Override
	public void addDraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlayer1Victory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlayer2Victory() {
		// TODO Auto-generated method stub
		
	}

}
