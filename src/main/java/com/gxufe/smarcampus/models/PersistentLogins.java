package com.gxufe.smarcampus.models;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PersistentLogins entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "persistent_logins", catalog = "smartcampus")
public class PersistentLogins implements java.io.Serializable {

	// Fields

	private String series;
	private String username;
	private String token;
	private Timestamp lastUsed;

	// Constructors

	/** default constructor */
	public PersistentLogins() {
	}

	/** minimal constructor */
	public PersistentLogins(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	/** full constructor */
	public PersistentLogins(String username, String token, Timestamp lastUsed) {
		this.username = username;
		this.token = token;
		this.lastUsed = lastUsed;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SERIES", unique = true, nullable = false, length = 64)
	public String getSeries() {
		return this.series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	@Column(name = "USERNAME", length = 64)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "TOKEN", length = 64)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "LAST_USED", nullable = false, length = 19)
	public Timestamp getLastUsed() {
		return this.lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

}