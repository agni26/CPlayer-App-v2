package cplayer.user.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cplayer.user.app.model.User;
import cplayer.user.app.service.UserService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<?> getUser(@RequestParam("username") String username) {
		Optional<User> user = userService.getUser(username);
		if (userService.getUser(username).isPresent()) {
			return new ResponseEntity<>(user , HttpStatus.CREATED);
		}
		else return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);

	}

	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user, @RequestParam("username") String username) {
		userService.updateUser(user, username);
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> adduser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>("Added", HttpStatus.CREATED);
	}

}
