package gz.porcobravo.rps.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchHistoryData {

	private Integer rounds;
	private Integer winsForPlayer1;
	private Integer winsForPlayer2;
	private Integer draws;
}
