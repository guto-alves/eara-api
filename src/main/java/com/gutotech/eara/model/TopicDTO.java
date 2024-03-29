package com.gutotech.eara.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class TopicDTO {

	private Long id;

	@NonNull
	private String name;

	private String annotation;

	private String totalTime;

	private List<StudySession> sessions = new ArrayList<>();
	
	private Subject subject;

	public TopicDTO(Topic topic) {
		this.id = topic.getId();
		this.name = topic.getName();
		this.annotation = topic.getAnnotation();
		this.totalTime = topic.getTotalTime();
		this.sessions = topic.getSessions();
		this.subject = topic.getSubject();
	}

	public int getTotalRightAnswers() {
		return sessions.stream().mapToInt(StudySession::getRightAnswers).sum();
	}

	public int getTotalWrongAnswers() {
		return sessions.stream().mapToInt(StudySession::getWrongAnswers).sum();
	}

	public int getTotalSessions() {
		return sessions.size();
	}

}
