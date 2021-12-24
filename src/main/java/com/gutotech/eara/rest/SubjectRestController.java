package com.gutotech.eara.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gutotech.eara.model.Subject;
import com.gutotech.eara.model.Topic;
import com.gutotech.eara.service.SubjectService;
import com.gutotech.eara.service.TopicService;

@RestController
@RequestMapping("subjects")
public class SubjectRestController {

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private TopicService topicService;

	@PostMapping
	public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
		subject = subjectService.save(subject);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(subject.getId())
				.toUri();
		return ResponseEntity.created(uri).body(subject);
	}

	@GetMapping("{id}/topics")
	public ResponseEntity<List<Topic>> getSubjectTopics(@PathVariable Long id) {
		Subject subject = subjectService.findById(id);
		return ResponseEntity.ok(subject.getTopics());
	}

	@PostMapping("{id}/topics")
	public ResponseEntity<Topic> addTopic(@RequestBody Topic topic, @PathVariable Long id) {
		Subject subject = subjectService.findById(id);
		topic.setSubject(subject);
		return ResponseEntity.ok(topicService.save(topic));
	}

}
