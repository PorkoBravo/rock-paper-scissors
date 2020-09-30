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
public class MatchHistory {

	private @NotNull Integer rounds;
	private @NotNull Integer winsForPlayer1;
	private @NotNull Integer winsForPlayer2;
	private @NotNull Integer draws;

	@Override
	public String toString() {
		return "#Rounds: " + rounds + " #Total wins for player_1: " + winsForPlayer1 + " #Total wins for player_2: "
				+ winsForPlayer2 + " #Total draws: " + draws;

	}
}
