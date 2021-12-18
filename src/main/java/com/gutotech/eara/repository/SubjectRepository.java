package com.gutotech.eara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.eara.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
