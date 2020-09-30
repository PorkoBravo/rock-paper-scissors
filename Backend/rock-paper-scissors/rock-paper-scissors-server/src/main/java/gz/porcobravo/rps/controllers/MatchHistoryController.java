package gz.porcobravo.rps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gz.porcobravo.dtos.MatchHistory;
import gz.porcobravo.rps.services.MatchHistoryService;

@RestController
@RequestMapping(path = "/history")
public class MatchHistoryController {
	
	@Autowired
	private MatchHistoryService history;

	@GetMapping
	public MatchHistory getMatchHistory() {
		return history.getMatchHistoy();
	}
}
