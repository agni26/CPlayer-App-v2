package cplayer.userauth.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cplayer.userauth.app.model.User;
import cplayer.userauth.app.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean deleteUser(String username) {
		if(userRepository.findById(username) != null) {
			userRepository.deleteById(username);
			return true;
		}
		else return false;
		
	}
	
	@Override
	public boolean addUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String passEncoded = passwordEncoder.encode(user.getPassword());
		user.setPassword(passEncoded);
		try {
			userRepository.save(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean validate(String username, String password) {
		if(userRepository.validate(username, password) != null ) {
			return true;
		}else {
			return false;
		}
	}
	
}
