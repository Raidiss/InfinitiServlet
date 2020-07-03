package com.infiniti.models;

import java.util.ArrayList;

public class Client extends User {
	

	private int planId;
	private ArrayList<Integer> issues;
	
	public Client(String username, String firstName, String lastName) {
		super(username, firstName, lastName);
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public ArrayList<Integer> getIssues() {
		return issues;
	}

	public void setIssues(ArrayList<Integer> issues) {
		this.issues = issues;
	}

	@Override
	public String toString() {
		return "Client [planId=" + planId + ", issues=" + issues + "]";
	}
	
}
