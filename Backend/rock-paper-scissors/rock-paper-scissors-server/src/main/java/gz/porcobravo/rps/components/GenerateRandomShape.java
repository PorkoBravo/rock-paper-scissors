package gz.porcobravo.rps.components;

import org.springframework.stereotype.Component;

import gz.porcobravo.dtos.Shapes;

@Component
public class GenerateRandomShape {
	private final static int MAX_RANDOM_VALUE = Shapes.values().length;

	public Shapes getRandomShape() {
		return generateFakeRandomShape(generateRandomNumber());
	}
	
	private int generateRandomNumber() {
		return (int) (Math.random()*MAX_RANDOM_VALUE);
	}
	
	private Shapes generateFakeRandomShape(int value) {
		if(value == 0) {
			return Shapes.PAPER;
		} else if(value == 1) {
			return Shapes.ROCK;
		} else return Shapes.SCISSORS;
	}
}
