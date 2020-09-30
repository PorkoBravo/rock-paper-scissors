package gz.porcobravo.rps.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import gz.porcobravo.dtos.Shapes;
import gz.porcobravo.rps.components.GenerateRandomNumber;

@SpringBootTest
public class MatchService_Should {

	@Autowired
	MatchService service;
	
	@MockBean
	GenerateRandomNumber mockedRandomNumberGenerator;
	
	@Test
	public void call_the_random_number_generator_1_time() {
		this.service.playNewMatch();
		
		verify(mockedRandomNumberGenerator, times(1)).generate(ArgumentMatchers.anyInt());
	}
	
	@Test
	public void call_the_random_number_generator_with_the_number_of_shapes_as_input() {
		this.service.playNewMatch();
		
		verify(mockedRandomNumberGenerator, times(1)).generate(Shapes.values().length);
	}
	
	
}
