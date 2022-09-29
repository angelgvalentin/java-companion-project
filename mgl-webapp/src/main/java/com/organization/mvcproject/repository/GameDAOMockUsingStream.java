package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.Game;

@Repository
public class GameDAOMockUsingStream {
	
	private static Long gameId = new Long(0);
//	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	
	public List<Game> retrieveAllGames() {
		return games;
	}

	
	



	public Game saveGame(Game updatedGame ) {
		if ( updatedGame .getId() != null) {
			Game foundGame = findGameById(updatedGame .getId());
			if (foundGame != null) {
				games = games.stream()
					.map(game -> game.getId().equals(updatedGame.getId()) ? updatedGame : game) 
					.collect(Collectors.toList());
			return updatedGame;
			}
			
			
		}
		updatedGame.setId(++gameId);
		games.add(updatedGame);
		return updatedGame;
	}
	
	
	
	public Game findGameById(Long id) {
		return games.stream()
				.filter(game -> id.equals(game.getId()))
				.findAny()
				.orElse(null);
	}
			
	
	public boolean deleteGameById(Long gameIdOfGameToDelete) {
		
		return games.removeIf(game -> gameIdOfGameToDelete.equals(game.getId()));
		
	}
	
	
	

}
