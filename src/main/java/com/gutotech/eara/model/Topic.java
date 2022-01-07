package com.gutotech.eara.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	@NotBlank(message = "Nome deve ser informado")
	@Column(length = 60, nullable = false)
	private String name;

	private String annotation;

	@NonNull
	@JsonIgnore
	@ManyToOne
	private Subject subject;

	@JsonIgnore
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	@OrderBy("id ASC")
	private List<StudySession> sessions = new ArrayList<>();

	public int getTotalRightAnswers() {
		return sessions.stream().mapToInt(StudySession::getRightAnswers).sum();
	}

	public int getTotalWrongAnswers() {
		return sessions.stream().mapToInt(StudySession::getWrongAnswers).sum();
	}

	public int getTotalSessions() {
		return sessions.size();
	}

	public String getTotalTime() {
		int totalMinutes = sessions.stream()
				.mapToInt((session) -> Integer.parseInt(session.getTotalTime().split(":")[0]) * 60
						+ Integer.parseInt(session.getTotalTime().split(":")[1]))
				.sum();
		if (totalMinutes > 0) {
			int totalHours = totalMinutes / 60;
			return String.format("%02d:%02d", totalHours, totalMinutes - totalHours * 60);
		}

		return "00:00";
	}

}
