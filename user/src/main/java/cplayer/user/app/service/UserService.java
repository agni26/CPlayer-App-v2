package cplayer.user.app.service;

import java.util.Optional;

import cplayer.user.app.model.User;

public interface UserService {
	public Optional<User> getUser(String username);
	public boolean updateUser(User u, String username);
	public boolean addUser(User u);
}
