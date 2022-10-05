package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.dao.GameDao;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

@Repository("gameStreamBasedDao")
public class GameStreamBasedDao implements GameDao {
	
	private static Long gameId = new Long(0);
	private static List<GameImpl> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	
	public List<Game> findAllGames(){
		return ImmutableList.copyOf(games);
	}

	
	



	public Game saveGame(Game updatedGame ) {
		if ( updatedGame.getId() != null) {
			Game foundGame = findGameById(updatedGame .getId());
			if (foundGame != null) {
				games = games.stream()
					.map(game -> game.getId().equals(updatedGame.getId()) ? (GameImpl) updatedGame : game) 
					.collect(Collectors.toList());
			return updatedGame;
			}
			
			
		}
		updatedGame.setId(++gameId);
		games.add( (GameImpl)updatedGame);
		return updatedGame;
	}
	
	
	
	public Game findGameById(Long id) {
		return games.stream()
				.filter(game -> id.equals(game.getId()))
				.findAny()
				.orElse(null);
	}
			
	
public boolean deleteGame(Long gameIdOfGameToDelete) {
		
		return games.removeIf(game -> gameIdOfGameToDelete.equals(game.getId()));
		
	}
	
	public List<Game> findGamesByGenre(String genre) {
		return games.stream()
				.filter(game -> genre.equals(game.getGenre()))
				.collect(Collectors.toList());
	}


	


	
	
	

}
