package com.gutotech.eara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.Project;
import com.gutotech.eara.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;

	public Project findById(Long id) {
		Optional<Project> optional = repository.findById(id);

		if (optional.isPresent()) {
			Project project = optional.get();
			if (project.getUser().getEmail().equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
				return project;
			}
		}

		throw new IllegalArgumentException("Projeto não encontrado.");
	}

	public List<Project> findAll() {
		return repository.findByUser_Email(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public Project save(Project project) {
		if (repository.findByNameAndUser_Email(project.getName(), project.getUser().getEmail()).size() > 0) {
			throw new IllegalArgumentException("Você já tem um projeto com esse nome");
		}
		
		return repository.save(project);
	}
	
	public Project update(Project project) {
		return repository.save(project);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
