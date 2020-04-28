package cplayer.user.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cplayer.user.app.model.User;
import cplayer.user.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public boolean updateUser(User user, int id) {
		try {
			userRepository.deleteById(id);
			userRepository.insert(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
