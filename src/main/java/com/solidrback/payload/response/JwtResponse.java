package com.solidrback.solidrback.payload.response;

import java.util.Date;
import java.util.List;

// Information sent to the front after login
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String email;
	private int statusId;
	private String username;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private String description;
	private String linkcontact;
	private Double userGaz;
	private Boolean isEnabled;
	private Boolean using2FA;
	private String secret;
	private List<String> roles;

	public JwtResponse(String accessToken, String email, int statusId, String username, String firstname, String lastname, Date birthdate, String description, String linkcontact, Double userGaz, Boolean isEnabled, Boolean using2FA, String secret, List<String> roles) {
		this.token = accessToken;
		this.email = email;
		this.statusId = statusId;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.description = description;
		this.linkcontact = linkcontact;
		this.userGaz = userGaz;
		this.isEnabled = isEnabled;
		this.using2FA = using2FA;
		this.secret = secret;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLinkcontact() {
		return linkcontact;
	}

	public void setLinkcontact(String linkcontact) {
		this.linkcontact = linkcontact;
	}

	public Double getUserGaz() {
		return userGaz;
	}

	public void setUserGaz(Double userGaz) {
		this.userGaz = userGaz;
	}

	public Boolean getEnabled() {
		return isEnabled;
	}

	public void setEnabled(Boolean enabled) {
		isEnabled = enabled;
	}

	public Boolean getUsing2FA() {
		return using2FA;
	}

	public void setUsing2FA(Boolean using2FA) {
		this.using2FA = using2FA;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public List<String> getRoles() {
		return roles;
	}
}
