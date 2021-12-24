package com.gutotech.eara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.StudySession;
import com.gutotech.eara.repository.StudySessionRepository;

@Service
public class StudySessionService {

	@Autowired
	private StudySessionRepository repository;

	public StudySession findById(Long id) {
		Optional<StudySession> optional = repository.findById(id);

		if (optional.isPresent()) {
			StudySession studySession = optional.get();

			if (studySession.getTopic().getSubject().getProject().getUser().getEmail()
					.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
				return studySession;
			}
		}

		throw new IllegalAccessError("Tópico não encontrada.");
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
