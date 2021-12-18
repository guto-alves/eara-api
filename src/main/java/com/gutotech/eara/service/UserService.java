package com.gutotech.eara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.User;
import com.gutotech.eara.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public User save(User User) {
		return repository.save(User);
	}

	public List<User> saveAll(List<User> Users) {
		return repository.saveAll(Users);
	}

}
