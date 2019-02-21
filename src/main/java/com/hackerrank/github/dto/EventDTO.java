package com.hackerrank.github.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDTO {

	private Long id;

	private String type;

	private ActorDTO actor;

	private RepoDTO repo;

	private Timestamp createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ActorDTO getActor() {
		return actor;
	}

	public void setActor(ActorDTO actor) {
		this.actor = actor;
	}

	public RepoDTO getRepo() {
		return repo;
	}

	public void setRepo(RepoDTO repo) {
		this.repo = repo;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
