package com.ecosystem.service;

import java.util.List;

import com.ecosystem.model.User;

public interface UserService {
	public void addUser(User user);
	
	public List<User> getUserList();
	
	public void removeUser(Integer id);
	
	public void updateUser(User user);
	
	public User find(Integer userId);
	
	public User findByEmail(String email);
}
