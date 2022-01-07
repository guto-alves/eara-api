package com.gutotech.eara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.eara.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	List<Project> findByUser_Email(String email);
	
	List<Project> findByNameAndUser_Email(String name, String email);
	
}
