package com.gutotech.eara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.Project;
import com.gutotech.eara.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;

	public Project findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Project> findAll() {
		return repository.findAll();
	}

	public Project save(Project Project) {
		return repository.save(Project);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
