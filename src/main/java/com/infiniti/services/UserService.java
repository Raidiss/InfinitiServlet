package com.infiniti.services;

import java.util.List;

import com.infiniti.dao.UserDAO;
import com.infiniti.dao.UserDAOImpl;
import com.infiniti.models.User;

public class UserService {
	UserDAO ud = new UserDAOImpl();

	public User getUser(int id) {
		return ud.getUser(id);
	}

	public User getUser(String username) {
		return ud.getUser(username);
	}

	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

	public boolean addUser(User u) {
		return ud.addUser(u);
	}

	public boolean updateUser(User change) {
		return ud.updateUser(change);
	}

	public boolean deleteUser(int id) {
		return ud.deleteUser(id);
	}

	public boolean deleteUser(String name) {
		User u = ud.getUser(name);
		return ud.deleteUser(u.getId());
	}
}
