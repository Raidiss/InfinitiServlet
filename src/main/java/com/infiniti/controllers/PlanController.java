package com.infiniti.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.infiniti.models.Plan;
import com.infiniti.services.PlanService;

public class PlanController {
	public static PlanService ps = new PlanService();
	public static Gson gson = new Gson();
	
	public static void getPlan(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//1) Handle the request
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("ID: " + id);
		
		//2) Use our Services
		Plan p = ps.getPlan(id);
		
		//3) Generate a response
		response.getWriter().append(gson.toJson(p));
	}
	
	public static void addPlan(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Plan p = gson.fromJson(request.getReader(), Plan.class);
		
		//add the plan
		ps.addPlan(p);
		
		//generate a response
		response.getWriter().append(gson.toJson(p));
		
	}
	
	public static void updatePlan(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		//Processing the request
		Plan change = gson.fromJson(request.getReader(), Plan.class);
		
		//call a service
		ps.updatePlan(change);
		
		//Generate a response
		response.getWriter().append(gson.toJson(change));
	}
	
	public static void deletePlan(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String[]> paramMap = request.getParameterMap();
		if(paramMap.containsKey("id")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean worked = ps.deletePlan(id);
			response.getWriter().append(Boolean.toString(worked));
		} else {
			response.getWriter().append(Boolean.toString(false));
		}
	}

	public static void getAllPlans(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Plan> plans = ps.getAllPlans();
		
		response.getWriter().append(gson.toJson(plans));
		
	}
	
}
