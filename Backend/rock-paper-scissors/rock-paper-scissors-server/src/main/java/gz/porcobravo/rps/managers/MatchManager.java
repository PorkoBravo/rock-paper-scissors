package gz.porcobravo.rps.managers;

import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gz.porcobravo.dtos.MatchResult;
import gz.porcobravo.dtos.Result;
import gz.porcobravo.dtos.Shapes;
import gz.porcobravo.rps.components.GenerateRandomNumber;
import gz.porcobravo.rps.services.MatchHistoryService;
import gz.porcobravo.rps.services.MatchService;

@Service
public class MatchManager implements MatchService{
	private final static Integer MAX_RANDOM_VALUE = Shapes.values().length;

	@Autowired
	private Map<Integer, Result> matchResultBean;
	
	@Autowired
	private BeanFactory beanFactory;

	@Autowired
	private GenerateRandomNumber randomGenerator;
	
	@Autowired
	private MatchHistoryService historyService;

	@Override
	public MatchResult playNewMatch() {
		MatchResult result = new MatchResult();
		result.setPlayer2Shape(Shapes.ROCK);
		
		Integer generatedNumber = this.randomGenerator.generate(MAX_RANDOM_VALUE);
		result.setResult(matchResultBean.get(generatedNumber));
		result.setPlayer1Shape(beanFactory.getBean(Shapes.class, generatedNumber));
		
		if(result.getResult() == Result.DRAW) {
			historyService.addDraw();
		} else if(result.getResult() == Result.PLAYER_1_WIN) {
			historyService.addPlayer1Victory();
		} else if(result.getResult() == Result.PLAYER_2_WIN) {
			historyService.addPlayer2Victory();
		}
		
		return result;
	}

}
