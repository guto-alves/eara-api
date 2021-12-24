package com.gutotech.eara.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gutotech.eara.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.gutotech.eara.model.User user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid email");
		}

		return new User(user.getEmail(), user.getPassword(), true, true, true, true,
				List.of(new SimpleGrantedAuthority("ROLE_USER")));
	}

}