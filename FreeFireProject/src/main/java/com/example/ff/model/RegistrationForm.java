package com.example.ff.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class RegistrationForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String main_email;
	public String getMain_email() {
		return main_email;
	}
	public void setMain_email(String main_email) {
		this.main_email = main_email;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="email")
	private LoginForm email;
	public LoginForm getEmail() {
		return email;
	}
	public void setEmail(LoginForm email) {
		this.email = email;
	}
	private String name;
	private String region;
	private int level;
	private String serverid;
	private String elite;
	private int kd_ratio;
	private int kills;
	private int matched;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getServerid() {
		return serverid;
	}
	public void setServerid(String serverid) {
		this.serverid = serverid;
	}
	public String getElite() {
		return elite;
	}
	public void setElite(String elite) {
		this.elite = elite;
	}
	public int getKd_ratio() {
		return kd_ratio;
	}
	public void setKd_ratio(int kd_ratio) {
		this.kd_ratio = kd_ratio;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getMatched() {
		return matched;
	}
	public void setMatched(int matched) {
		this.matched = matched;
	}
	public RegistrationForm() {
		super();
		// TODO Auto-generated constructor stub
	}
}
