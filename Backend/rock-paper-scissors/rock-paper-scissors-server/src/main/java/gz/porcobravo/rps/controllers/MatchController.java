package gz.porcobravo.rps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gz.porcobravo.dtos.MatchResult;
import gz.porcobravo.rps.services.MatchService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/match")
public class MatchController {
	
	@Autowired
	private MatchService matchService;
	
	@PostMapping
	public MatchResult playNewMatch() {
		return matchService.playNewMatch();
	}

}
