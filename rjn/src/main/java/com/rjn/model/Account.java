package com.rjn.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;

@Entity
@Table(name="ACCOUNT") 
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "my_user_name", nullable = false)
	private String my_user_name;
	
	@NotNull
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotNull
	@Column(name="",nullable=false)
	private String reg_id;
	
	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	@NotNull
	private boolean enabled = true;
	
	@NotNull
	private boolean credentialsexpired = false;
	
	@NotNull
	private boolean expired = false;
	
	@NotNull
	private boolean locked = false;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
			name="AccountRole",
			joinColumns = @JoinColumn(
					name="accountId", 
					referencedColumnName="id"),
					inverseJoinColumns = @JoinColumn(
							name = "roleId", 
							referencedColumnName="id" ))
	
	private Set<Role> roles;
	
	public Account() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMy_user_name() {
		return my_user_name;
	}

	public void setMy_user_name(String my_user_name) {
		this.my_user_name = my_user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isCredentialsexpired() {
		return credentialsexpired;
	}

	public void setCredentialsexpired(boolean credentialsexpired) {
		this.credentialsexpired = credentialsexpired;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
