package com.cosi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosi.iservice.IUserService;
import com.cosi.mapper.UserMapper;
import com.cosi.vo.User;

@Service("userService")
public class UserService implements IUserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public void saveUser(User user) {
		
		userMapper.saveUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUserById(int id) {
		userMapper.deleteUserById(id);
		
	}

	@Override
	public User getUserById(int id) {
		
		User user = userMapper.getUserById(id);
		
		return user;
	}

	@Override
	public List<User> getUsers() {
		
		List<User> users = userMapper.getUsers();
		
		return users;
	}

	
	
}
