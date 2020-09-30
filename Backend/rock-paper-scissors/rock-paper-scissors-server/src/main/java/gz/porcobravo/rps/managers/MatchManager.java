package gz.porcobravo.rps.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gz.porcobravo.dtos.MatchResult;
import gz.porcobravo.dtos.Shapes;
import gz.porcobravo.rps.components.GenerateRandomNumber;
import gz.porcobravo.rps.services.MatchService;

@Service
public class MatchManager implements MatchService{
	private final static int MAX_RANDOM_VALUE = Shapes.values().length;
	 
	@Autowired
	GenerateRandomNumber randomGenerator;

	@Override
	public MatchResult playNewMatch() {
		int generatedNumber = this.randomGenerator.generate(MAX_RANDOM_VALUE);
		
		return null;
	}

}
