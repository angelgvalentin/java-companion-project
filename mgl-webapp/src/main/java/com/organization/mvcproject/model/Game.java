package com.organization.mvcproject.model;

import org.springframework.stereotype.Component;

@Component
public class Game {

	
	private Long id;
	private String name;
	private String genre;

	public Long getGame_id() {
		return id;
	}

	public void setGame_id(Long id) {
		this.id = id;
	}

	public String getGame_name() {
		return name;
	}

	public void setGame_name(String name) {
		this.name = name;
	}

	public String getGame_genre() {
		return genre;
	}

	public void setGame_genre(String genre) {
		this.genre = genre;
	}

}
