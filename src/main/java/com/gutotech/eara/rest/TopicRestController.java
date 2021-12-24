package com.gutotech.eara.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.eara.model.StudySession;
import com.gutotech.eara.model.Topic;
import com.gutotech.eara.model.TopicDTO;
import com.gutotech.eara.service.StudySessionService;
import com.gutotech.eara.service.TopicService;

@RestController
@RequestMapping("topics")
public class TopicRestController {

	@Autowired
	private TopicService topicService;

	@Autowired
	private StudySessionService sessionService;

	@GetMapping("{id}")
	public ResponseEntity<TopicDTO> getTopic(@PathVariable Long id) {
		return ResponseEntity.ok(new TopicDTO(topicService.findById(id)));
	}

	@GetMapping("{id}/sessions")
	public ResponseEntity<List<StudySession>> getStudySessions(@PathVariable Long id) {
		return ResponseEntity.ok(topicService.findById(id).getSessions());
	}

	@PostMapping("{id}/sessions")
	public ResponseEntity<StudySession> addTopicStudySession(@RequestBody StudySession session, @PathVariable Long id) {
		Topic topic = topicService.findById(id);
		session.setTopic(topic);
		return ResponseEntity.ok(sessionService.save(session));
	}

}
