package com.developer.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountUserDetailsService  implements UserDetailsService{
	AccountRepo repo;
	@Autowired
	public AccountUserDetailsService(AccountRepo repo, 
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.repo = repo;
	}

	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> account = repo.findByUsername(username);
		return account.map(e -> 
		new User(e.getUsername(),e.getPassword(),true,true,true,true, AuthorityUtils.createAuthorityList("ROLE_USER"))
				).orElseThrow(() -> new UsernameNotFoundException("not in db"));
	}

}
