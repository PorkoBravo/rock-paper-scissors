package gz.porcobravo.rps;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import gz.porcobravo.dtos.Result;
import gz.porcobravo.dtos.Shapes;

@Configuration
public class MatchConfiguration {
	
	@Value("${match.rock}")
	private Integer ROCK;
	
	@Value("${match.paper}")
	private Integer PAPER;
	
	@Value("${match.scissors}")
	private Integer SCISSORS;

	@Bean(autowireCandidate = true, name = "matchResultBean")
	public Map<Integer, Result> matchResult() {
		Map<Integer, Result> matchResult = new HashMap<>();
		matchResult.put(ROCK, Result.DRAW);
		matchResult.put(PAPER, Result.PLAYER_1_WIN);
		matchResult.put(SCISSORS, Result.PLAYER_2_WIN);
		return matchResult;
	}
	
	@Bean(autowireCandidate = true, name = "shapeBean")
	@Scope(value = "prototype")
	public Shapes getShape(Integer value) {
		if(value == ROCK) return Shapes.ROCK;
		else if(value == PAPER) return Shapes.PAPER;
		else return Shapes.SCISSORS;
	}
}
