package gz.porcobravo.rps.components;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GenerateRandomNumber.class)
public class GenerateRandomShape_Should {

	@Autowired
	GenerateRandomNumber randomGenerator;
	
	@Test
	public void return_a_number() {
		final int no_matters_number = 10;
		int result = this.randomGenerator.generate((no_matters_number));
		assertNotNull(result);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 5, 1})
	public void return_a_number_not_greater_than_maximum_value_passed_as_input(int maximumValue) {
		int result = this.randomGenerator.generate((maximumValue));
		assertTrue(result < maximumValue);
	}
}
