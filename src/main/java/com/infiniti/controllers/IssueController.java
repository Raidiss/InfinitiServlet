package com.infiniti.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.infiniti.models.Issue;
import com.infiniti.services.IssueService;

public class IssueController {
	
	public static IssueService iss = new IssueService();
	public static Gson gson = new Gson();
	
	public static void getIssue(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//1) Handle the request
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("ID: " + id);
		
		//2) Use our Services
		Issue issue = iss.getIssue(id);
		
		//3) Generate a response
		response.getWriter().append(gson.toJson(issue));
	}
	
	public static void getAllIssues(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Issue> issues = iss.getAllIssues();
		
		response.getWriter().append(gson.toJson(issues));
		
	}
	
	public static void createIssue(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Issue issue = gson.fromJson(request.getReader(), Issue.class);
		
		//add the issue
		iss.createIssue(issue);	
		//generate a response
		response.getWriter().append(gson.toJson(issue));
		
	}
	
	public static void changeIssueStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		//Processing the request
		Issue change = gson.fromJson(request.getReader(), Issue.class);
		
		//call a service
		iss.changeIssueStatus(change);
		//Generate a response
		response.getWriter().append(gson.toJson(change));
	}
	
	public static void deleteIssue(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String[]> paramMap = request.getParameterMap();
		if(paramMap.containsKey("id")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean worked = iss.deleteIssue(id);
			response.getWriter().append(Boolean.toString(worked));
		} else {
			response.getWriter().append(Boolean.toString(false));
		}
	}

}
