package cplayer.userauth.app.service;

import cplayer.userauth.app.model.User;

public interface UserService {
	public boolean deleteUser(String u);
	public boolean addUser(User u);
	public boolean validate(String username,String password);

}
