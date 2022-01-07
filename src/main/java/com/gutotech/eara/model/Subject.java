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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@NotNull(message = "Nome deve ser informado")
	@Column(length = 60, nullable = false)
	private String name;

	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private List<Topic> topics = new ArrayList<>();

	@NonNull
	@NotNull(message = "Projeto deve ser informado")
	@ManyToOne
	private Project project;

}
