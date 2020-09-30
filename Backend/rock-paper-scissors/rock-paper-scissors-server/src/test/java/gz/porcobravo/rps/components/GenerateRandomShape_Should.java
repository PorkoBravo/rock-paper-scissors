package gz.porcobravo.rps.components;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gz.porcobravo.dtos.Shapes;

@SpringBootTest(classes = GenerateRandomShape.class)
public class GenerateRandomShape_Should {

	@Autowired
	GenerateRandomShape randomGenerator;
	
	@Test
	public void return_just_a_shape() {
		Shapes shape = this.randomGenerator.getRandomShape();
		assertNotNull(shape);
	}
}
