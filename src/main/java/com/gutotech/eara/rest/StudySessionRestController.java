package com.gutotech.eara.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.eara.model.StudySession;
import com.gutotech.eara.service.StudySessionService;

@RestController
@RequestMapping("sessions")
public class StudySessionRestController {

	@Autowired
	private StudySessionService sessionService;

	@GetMapping("{id}")
	public ResponseEntity<StudySession> getTopic(@PathVariable Long id) {
		return ResponseEntity.ok(sessionService.findById(id));
	}

	@DeleteMapping("{id}/sessions")
	public ResponseEntity<StudySession> addTopicStudySession(StudySession session) {
		sessionService.delete(session);
		return ResponseEntity.noContent().build();
	}

}
