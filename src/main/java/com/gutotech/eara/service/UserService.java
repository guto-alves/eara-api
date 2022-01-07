package com.gutotech.eara.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.User;
import com.gutotech.eara.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findById(Long id) {
		// TODO: throws not find exception
		return repository.findById(id).orElse(null);
	}

	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

	public User register(User user) {
		if (findByEmail(user.getEmail()) != null) {
			throw new IllegalArgumentException("E-mail já existe");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}

	public User save(User user) {
		User user2 = findByEmail(user.getEmail());
		if (user2 != null && !user.getId().equals(user2.getId())) {
			throw new IllegalArgumentException(
					"E-mail para o qual você está tentando mudar já está associado a outra conta");
		}
		return repository.save(user);
	}

	public User findCurrentUser() {
		return repository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
	}

}
