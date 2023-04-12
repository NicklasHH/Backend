package back.Harjoitustyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appuser")
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "tunnus", nullable = false, unique = true)
	private String username;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Column(name = "rooli")
	private String role;

	public AppUser() {
	}

	public AppUser(String username, String passwordHash, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	public AppUser(String username, String passwordHash) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
