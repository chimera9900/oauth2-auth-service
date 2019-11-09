package com.developer.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
class Account{	
	@Id
    @GeneratedValue
    private Long id;
    private String username, password;
    private boolean active;
	public Account(String username, String password, boolean active) {
		this.username = username;
		this.password = password;
		this.active = active;
	}
}	
    