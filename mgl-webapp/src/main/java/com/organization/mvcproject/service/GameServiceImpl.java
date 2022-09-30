package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.mockdao.GameDAOMock;
import com.organization.mvcproject.mockdao.GameDAOMockUsingStream;
import com.organization.mvcproject.model.Game;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAOMockUsingStream gameDaoMock;

	@Override
	public List<Game> retrieveAllGames() {
		return gameDaoMock.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return gameDaoMock.saveGame(game);

	}
	
	
	
	

	@Override
	public boolean deleteGame(Long gameId) {
		return gameDaoMock.deleteGameById(gameId);
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