package com.example.freefire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="free_fire")
public class FreeFire {
	@Id
	private int id;
	private String name;
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	private String region;
	private int level;
	private String serverid;
	private String elite;
	private int kd_ratio;
	
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
	
}
