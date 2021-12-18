package com.gutotech.eara.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "study_sessions")
public class StudySession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	@Column(name = "creation_date")
	private Date creationDate;

	private String totalTime;

	@Column(name = "right_answers")
	private int rightAnswers;

	@Column(name = "wrong_answers")
	private int wrongAnswers;

	private String obs;

	@JsonIgnore
	@ManyToOne
	private Topic topic;

}
