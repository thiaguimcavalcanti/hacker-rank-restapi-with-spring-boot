package com.hackerrank.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActorDTO {

	private Long id;

	private String login;

	@JsonProperty("avatar_url")
	private String avatar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
