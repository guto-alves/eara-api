package com.gutotech.eara.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gutotech.eara.model.PasswordForm;
import com.gutotech.eara.model.User;
import com.gutotech.eara.model.UserDTO;
import com.gutotech.eara.service.UserService;

@RestController
@RequestMapping("users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("me")
	public ResponseEntity<User> getUser() {
		User user = userService
				.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName().toString());

		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<User> register(@Valid @RequestBody User user) {
		userService.register(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest() //
				.path("/me") //
				.build() //
				.toUri();

		return ResponseEntity.created(uri).body(user);
	}

	@PutMapping
	public ResponseEntity<User> update(@Valid @RequestBody UserDTO user) {
		User currentUser = userService.findCurrentUser();
		currentUser.setName(user.getName());
		userService.save(currentUser);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("change-password")
	public ResponseEntity<User> changePassword(@Valid @RequestBody PasswordForm passwordForm) {
		userService.changePassword(passwordForm);
		return ResponseEntity.noContent().build();
	}
}
