package org.java.employee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="usertable")
public class User {
	
	@NotBlank()
	@Size(min=5,max=100)
	@Id
	private String username;
	@NotBlank()
	@Size(min=5,max=100)
	private String password;
	@NotBlank()
	private String email;
	private String authority;
	private boolean enabled = false;
	
	public User(){}
	public User(String username, String password, String email, String authority, boolean enabled) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.authority = authority;
		this.enabled = enabled;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", authority=" + authority
				+ ", enabled=" + enabled + "]";
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getAuthority() {
		return authority;
	}
	public boolean isEnabled() {
		return enabled;
	}
	
	
}
