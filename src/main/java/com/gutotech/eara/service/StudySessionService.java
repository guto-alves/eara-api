package com.gutotech.eara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.StudySession;
import com.gutotech.eara.repository.StudySessionRepository;

@Service
public class StudySessionService {

	@Autowired
	private StudySessionRepository repository;

	public StudySession findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<StudySession> findAll() {
		return repository.findAll();
	}

	public StudySession save(StudySession studySession) {
		return repository.save(studySession);
	}

	public void delete(StudySession session) {
		repository.delete(session);
	}

}
