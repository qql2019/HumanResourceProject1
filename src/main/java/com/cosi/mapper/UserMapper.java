package com.cosi.mapper;

import java.util.List;

import com.cosi.vo.User;

public interface UserMapper {
	
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUserById(int id);
	public User getUserById(int id);
	public List<User> getUsers();

}
