package com.gutotech.eara.rest;

import java.net.URI;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gutotech.eara.model.Project;
import com.gutotech.eara.model.Subject;
import com.gutotech.eara.service.ProjectService;
import com.gutotech.eara.service.UserService;

@RestController
@RequestMapping("projects")
public class ProjectRestController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Project>> getProject() {
		List<Project> projects = projectService.findAll();
		projects.sort(Comparator.comparing(Project::getAccessDate).reversed());
		return ResponseEntity.ok(projects);
	}

	@GetMapping("{id}")
	public ResponseEntity<Project> getProject(@PathVariable Long id) {
		Project project = projectService.findById(id);
		project.setAccessDate(new Date());
		projectService.save(project);
		return ResponseEntity.ok(project);
	}

	@PostMapping
	public ResponseEntity<Project> addProject(@Valid @RequestBody Project project) {
		project.setAccessDate(new Date());
		project.setUser(userService.findCurrentUser());
		project = projectService.create(project);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest() //
				.path("/{id}") //
				.buildAndExpand(project.getId()) //
				.toUri();

		return ResponseEntity.created(uri).body(project);
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> updateProject(@Valid @RequestBody Project updatedProject, @PathVariable Long id) {
		Project project = projectService.findById(id);
		project.setName(updatedProject.getName());
		project.setDescription(updatedProject.getDescription());
		project.setColor(updatedProject.getColor());
		projectService.save(project);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
		projectService.findById(id);
		projectService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}/subjects")
	public ResponseEntity<List<Subject>> getProjectSubjects(@PathVariable Long id) {
		return ResponseEntity.ok(projectService.findById(id).getSubjects());
	}

}
