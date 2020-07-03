package com.infiniti.dao;

import java.util.List;

import com.infiniti.models.Plan;

public interface PlanDAO {
	
	//CRUD operations
	
	public Plan getPlan(int id);
	public Plan getPlan(String name);
	public List<Plan> getAllPlans();
	public boolean addPlan(Plan p);
	public boolean updatePlan(Plan change);
	public boolean deletePlan(int id);
}
