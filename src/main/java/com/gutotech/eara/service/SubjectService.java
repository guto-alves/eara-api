package com.gutotech.eara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.Subject;
import com.gutotech.eara.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository repository;

	public Subject findById(Long id) {
		Optional<Subject> optional = repository.findById(id);

		if (optional.isPresent()) {
			Subject subject = optional.get();

			if (subject.getProject().getUser().getEmail()
					.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
				return subject;
			}
		}

		throw new IllegalAccessError("Disiciplina não encontrada.");
	}

	public Subject save(Subject subject) {
		if (repository.exists(subject.getName(), subject.getProject())) {
			throw new IllegalArgumentException(
					"Já existe uma disciplina com o nome " + subject.getName() + " nesse projeto");
		}

		return repository.save(subject);
	}

	public List<Subject> saveAll(List<Subject> subjects) {
		return repository.saveAll(subjects);
	}

}
