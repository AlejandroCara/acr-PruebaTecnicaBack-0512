package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Party;
import com.example.demo.dto.User;
import com.example.demo.security.VideoGamesUserDetails;
import com.example.demo.service.PartyService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/party")
public class PartyController {

	@Autowired(required = true)
	PartyService partyService;
	
	@Autowired(required = true)
	UserService userService;

	@GetMapping("/game")
	public ResponseEntity<List<Party>> listAllParties(@RequestParam(name = "id", required = true) Integer idGame) {
		
		List<Party> parties = null;

		if (idGame != null) {
			parties = partyService.getAllByGame(idGame);
		}


		return new ResponseEntity<>(parties, HttpStatus.OK);
	}


	@PostMapping("/add")
	public Party saveParty(@RequestBody Party party) {
		return partyService.add(party);
	}
	
	@PutMapping("/join")
	public User joinParty(@RequestParam(name = "id", required = true) Integer idParty, Authentication authentication) {
		VideoGamesUserDetails ud = (VideoGamesUserDetails) authentication.getPrincipal();
		User user = userService.getOne(ud.getUsername());
		Party party = partyService.getOne(idParty);
		user.setParty(party);
		userService.update(user);
		return user;
	}
	
	@PutMapping("/exit")
	public User exitParty(@RequestParam(name = "id", required = true) Integer idParty, Authentication authentication) {
		VideoGamesUserDetails ud = (VideoGamesUserDetails) authentication.getPrincipal();
		User user = userService.getOne(ud.getUsername());
		user.setParty(null);
		userService.update(user);
		return user;
	}


	private Party convertToDTO(Party party) {
		return new Party(party.getId(), party.getName(), party.getGame());
	}
}
