package com.gutotech.eara.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "topics")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String name;

	private String annotation;

	@NonNull
	@JsonIgnore
	@ManyToOne
	private Subject subject;

	@JsonIgnore
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private List<StudySession> sessions = new ArrayList<>();

	public int getTotalRightAnswers() {
		return sessions.stream()
				.mapToInt(StudySession::getRightAnswers)
				.sum();
	}
	
	public int getTotalWrongAnswers() {
		return sessions.stream()
				.mapToInt(StudySession::getWrongAnswers)
				.sum();
	}
	
	public int getTotalSessions() {
		return sessions.size();
	}
	
}
