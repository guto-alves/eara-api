package com.gutotech.eara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.eara.model.Topic;
import com.gutotech.eara.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	public Topic findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Topic> findAll() {
		return repository.findAll();
	}

	public Topic save(Topic Topic) {
		return repository.save(Topic);
	}

	public List<Topic> saveAll(List<Topic> Topics) {
		return repository.saveAll(Topics);
	}

}
