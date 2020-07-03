package com.infiniti.services;

import java.util.List;

import com.infiniti.dao.PlanDAO;
import com.infiniti.dao.PlanDAOImpl;
import com.infiniti.models.Plan;

public class PlanService {
	PlanDAO pd = new PlanDAOImpl();

	// This class is for performing any business logic operations
	// But I will start simply with some basic CRUD operation calls.

	public Plan getPlan (int id) {
		return pd.getPlan(id);
	}

	public List<Plan> getAllPlans() {
		return pd.getAllPlans();
	}

	public boolean addPlan(Plan p) {
		return pd.addPlan(p);
	}

	public boolean updatePlan(Plan change) {
		return pd.updatePlan(change);
	}

	public boolean deletePlan(int id) {
		return pd.deletePlan(id);
	}

	public boolean deletePlan(String name) {
		Plan p = pd.getPlan(name);
		return pd.deletePlan(p.getId());
	}

}
