package gz.porcobravo.rps.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gz.porcobravo.dtos.MatchResult;
import gz.porcobravo.dtos.Shapes;
import gz.porcobravo.rps.components.GenerateRandomNumber;
import gz.porcobravo.rps.services.MatchService;

@Service
public class MatchManager implements MatchService{
	private final static Integer MAX_RANDOM_VALUE = Shapes.values().length;
	
	private final static Integer ROCK = 0;
	private final static Integer PAPER = 1;
	private final static Integer SCISSORS = 2;
	 
	@Autowired
	GenerateRandomNumber randomGenerator;

	@Override
	public MatchResult playNewMatch() {
		MatchResult result = new MatchResult();
		result.setPlayer2Shape(Shapes.ROCK);
		
		Integer generatedNumber = this.randomGenerator.generate(MAX_RANDOM_VALUE);
		if(generatedNumber == ROCK) {
			result.setPlayer1Shape(Shapes.ROCK);
		} else if(generatedNumber == PAPER) {
			result.setPlayer1Shape(Shapes.PAPER);
		} else if(generatedNumber == SCISSORS) {
			result.setPlayer1Shape(Shapes.SCISSORS);
		}
		
		return result;
	}

}
