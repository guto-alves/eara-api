package com.gutotech.eara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.eara.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
