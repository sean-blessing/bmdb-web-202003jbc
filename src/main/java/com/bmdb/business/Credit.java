package com.bmdb.business;

import javax.persistence.*;

@Entity
public class Credit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int actorId;
	private int movieId;
	private String role;
	
	public Credit(int id, int actorId, int movieId, String role) {
		super();
		this.id = id;
		this.actorId = actorId;
		this.movieId = movieId;
		this.role = role;
	}

	public Credit() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", actorId=" + actorId + ", movieId=" + movieId + ", role=" + role + "]";
	}
}