package cplayer.user.app.controller;


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
	
	long expireTime = 180000;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getUser(@RequestParam("username") String username){
		return new ResponseEntity<Integer>(user.getUserid(), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user, @RequestParam("id") int id) {
		userService.updateUser(user, id);
		return new ResponseEntity<Integer>(user.getUserid(), HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody User user) {
		return new ResponseEntity<Integer>(user.getUserid(), HttpStatus.CREATED);
	}
	
	

}
