package com.gutotech.eara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.Subject;
import com.gutotech.eara.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository repository;
	
	public Subject findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Subject> findAll() {
		return repository.findAll();
	}

	public Subject save(Subject subject) {
		return repository.save(subject);
	}

	public List<Subject> saveAll(List<Subject> subjects) {
		return repository.saveAll(subjects);
	}

}
