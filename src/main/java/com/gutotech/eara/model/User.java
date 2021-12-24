package com.gutotech.eara.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@NotBlank(message = "Nome deve ser informado")
	private String name;

	@NonNull
	@Email(message = "Email deve ser um endereço de e-mail bem formado")
	@Column(unique = true)
	private String email;

	@NonNull
	@NotBlank
	@Size(min = 4, message = "Senha deve ter no mínino 4 caracters")
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Project> projects = new ArrayList<>();

}
