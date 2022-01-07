package com.gutotech.eara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.eara.model.Project;
import com.gutotech.eara.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	@Query("select case when (count(s.id) = 0) then false else true end "
			+ "from Subject s where s.project = ?2 and s.name = ?1")
	Boolean exists(String subjectName, Project project);

}
