package gz.porcobravo.dtos;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchResult {

	private @NotNull Shapes player1Shape;
	private @NotNull Shapes player2Shape;
	private @NotNull Result result;
	
}
