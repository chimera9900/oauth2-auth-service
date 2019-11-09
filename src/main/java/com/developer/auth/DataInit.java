package com.developer.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
	@Autowired
	AccountRepo repo;
	@Autowired
	BCryptPasswordEncoder  bCryptPasswordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Account("jen",bCryptPasswordEncoder.encode("jen123"), true));
	}

}
