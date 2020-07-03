package com.infiniti.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.infiniti.models.User;
import com.infiniti.services.UserService;

public class UserController {
	public static UserService us = new UserService();
	public static Gson gson = new Gson();

	public static void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

		User u = null;
		// 1) Handle the request
		Map<String, String[]> paramMap = request.getParameterMap();
		if (paramMap.containsKey("id")) {
			int id = Integer.parseInt(request.getParameter("id"));

			u = us.getUser(id);
		} else if (paramMap.containsKey("username")) {
			String username = request.getParameter("username");

			u = us.getUser(username);
		}

		// 2) Use our Services

		// 3) Generate a response
		response.getWriter().append(gson.toJson(u));
	}

	public static void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

		User u = gson.fromJson(request.getReader(), User.class);

		// add the plan
		us.addUser(u);

		// generate a response
		response.getWriter().append(gson.toJson(u));

	}

	public static void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Processing the request
		User change = gson.fromJson(request.getReader(), User.class);

		// call a service
		us.updateUser(change);

		// Generate a response
		response.getWriter().append(gson.toJson(change));
	}

	public static void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String[]> paramMap = request.getParameterMap();
		if (paramMap.containsKey("id")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean worked = us.deleteUser(id);
			response.getWriter().append(Boolean.toString(worked));
		} else {
			response.getWriter().append(Boolean.toString(false));
		}
	}

	public static void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<User> users = us.getAllUsers();

		response.getWriter().append(gson.toJson(users));

	}

}
