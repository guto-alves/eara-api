package com.gutotech.eara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.eara.model.Subject;
import com.gutotech.eara.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	@Query("select case when (count(t) = 0) then false else true end "
			+ "from Topic t where t.subject = ?2 and t.name = ?1")
	Boolean exists(String topicName, Subject subject);

}
