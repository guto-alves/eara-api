package com.gutotech.eara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.eara.model.StudySession;

@Repository
public interface StudySessionRepository extends JpaRepository<StudySession, Long> {

}
