package com.infiniti.dao;

import java.util.List;

import com.infiniti.models.User;

public interface UserDAO {
	public User getUser(int id);
	public User getUser(String name);
	public List<User> getAllUsers();
	public boolean addUser (User u);
	public boolean updateUser(User change);
	public boolean deleteUser(int id);

}
