package com.infiniti.models;

import java.util.ArrayList;

public class Tech extends User {
	private ArrayList<Integer> workedOnIssues;
	
	public Tech(String username, String firstName, String lastName) {
		super(username, firstName, lastName);
	}

	public ArrayList<Integer> getWorkedOnIssues() {
		return workedOnIssues;
	}

	public void setWorkedOnIssues(ArrayList<Integer> workedOnIssues) {
		this.workedOnIssues = workedOnIssues;
	}

	@Override
	public String toString() {
		return "Tech [workedOnIssues=" + workedOnIssues + "]";
	}

}
