package com.gutotech.eara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.Topic;
import com.gutotech.eara.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	public Topic findById(Long id) {
		Optional<Topic> optional = repository.findById(id);

		if (optional.isPresent()) {
			Topic topic = optional.get();

			if (topic.getSubject().getProject().getUser().getEmail()
					.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
				return topic;
			}
		}

		throw new IllegalAccessError("Tópico não encontrada.");
	}

	public Topic save(Topic Topic) {
		return repository.save(Topic);
	}

	public List<Topic> saveAll(List<Topic> Topics) {
		return repository.saveAll(Topics);
	}

}
