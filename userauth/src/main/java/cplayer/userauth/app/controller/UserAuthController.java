package cplayer.userauth.app.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cplayer.userauth.app.model.User;
import cplayer.userauth.app.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("api/auth")
public class UserAuthController {
	
	long expireTime = 600000;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("register")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>(user.getUsername(), HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delUser(@RequestParam String username){
		userService.deleteUser(username);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody User user) {

		String jwtToken = "";
		Map<String,String> map = new HashMap<>();		
		try {
			
			jwtToken = getToken(user.getUsername(),user.getPassword());
			map.clear();
			map.put("message", "User logged in successfully");
			map.put("Token",jwtToken);
			
		}catch(Exception e) {
			map.clear();
			map.put("message",e.getMessage());
			map.put("Token",null);
		}
		userService.addUser(user);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	public String getToken(String username,String password) throws Exception {
		
		if(username == null || password == null) {
			throw new ServletException("Please fill the Username and Password");
		}
		boolean status = userService.validate(username,password);
		if(!status) {
			throw new ServletException("Invalid Credentials");
		}
		String jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date())
							.setExpiration(new Date(System.currentTimeMillis()+ expireTime))
							.signWith(SignatureAlgorithm.HS256, "Cplayer_App_key").compact();
		return jwtToken;
	}

}
