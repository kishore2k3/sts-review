package com.example.freefire.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Tournament {
	@Id
	private int id;
	private String tournament_name;
	private String server;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="participated_tournament")
	private List<FreeFire> tournament;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="player_won")
	private FreeFire playerWon;
	public FreeFire getPlayerWon() {
		return playerWon;
	}
	public void setPlayerWon(FreeFire playerWon) {
		this.playerWon = playerWon;
	}
	public List<FreeFire> getTournament() {
		return tournament;
	}
	public void setTournament(List<FreeFire> tournament) {
		this.tournament = tournament;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTournament_name() {
		return tournament_name;
	}
	public void setTournament_name(String tournament_name) {
		this.tournament_name = tournament_name;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}

}
