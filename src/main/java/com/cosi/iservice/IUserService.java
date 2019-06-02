package com.cosi.iservice;

import java.util.List;

import com.cosi.vo.User;

public interface IUserService {

	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUserById(int id);
	public User getUserById(int id);
	public List<User> getUsers();
	
}
