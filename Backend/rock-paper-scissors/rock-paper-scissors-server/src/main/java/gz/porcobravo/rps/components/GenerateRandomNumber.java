package gz.porcobravo.rps.components;

import org.springframework.stereotype.Component;

@Component
public class GenerateRandomNumber {
	
	public int generate(int maximumRandomValue) {
		return (int) (Math.random()*maximumRandomValue);
	}
}
