package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.dao.GameDao;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
//	@Qualifier("gameStreamBasedDao")
	private GameDao gameDaoMock;

	@Override
	public List<Game> retrieveAllGames() {
		return gameDaoMock.findAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return gameDaoMock.saveGame(game);

	}
	
	
	
	

	@Override
	public boolean deleteGame(Long gameId) {
		return gameDaoMock.deleteGame(gameId);
	}

	@Override
	public Game findGameById(Long id) {
		
		return gameDaoMock.findGameById(id);
	}

	

	@Override
	public List<Game> findGamesByGenre(String genre) {
		return gameDaoMock.findGamesByGenre(genre);
	}



}