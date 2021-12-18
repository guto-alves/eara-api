package com.gutotech.eara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.eara.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
