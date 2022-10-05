package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.model.Review;

@RestController
public class GameAndReviewController {

	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
	
		return new ModelAndView("reviewCreatePage", "command", new Review());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
	
		return new ModelAndView("reviewDetailPage", "submittedReview", review);
	}
	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		return new ModelAndView("gamesPage", "command", new GameImpl());
	}
	
	
	
	

	
	@PostMapping(value = "/games", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	
	@GetMapping(value = "games/getAll")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateGame(@RequestBody GameImpl game) {		
		return new ResponseEntity<>(gameService.saveGame(game), HttpStatus.OK);
	}
	
	
	// URL local host:8081/game/1  (DELETE)  
	@DeleteMapping(value = "/games/{id}" )
	public ResponseEntity<?> deleteGame(@PathVariable("id") Long gameId ){
		return new ResponseEntity<>(gameService.deleteGame(gameId), HttpStatus.OK);
	}
	
	
	
	
	
	
}