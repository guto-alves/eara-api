package com.gutotech.eara.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@NotBlank(message = "Nome deve ser informado")
	@Size(min = 2, max = 60, message = "O tamanho do Nome deve ser entre 2 e 60")
	@Column(length = 60, nullable = false)
	private String name;

	@Size(max = 255, message = "O tamanho da Descrição deve ser no máximo até 60")
	private String description;

	@NotNull
	private Date accessDate = new Date();

	@JsonIgnore
	@ManyToOne
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
	private List<Subject> subjects = new ArrayList<>();

	private String color;

}
