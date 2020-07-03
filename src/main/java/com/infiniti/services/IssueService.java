package com.infiniti.services;

import java.util.List;

import com.infiniti.dao.IssueDAO;
import com.infiniti.dao.IssueDAOImpl;
import com.infiniti.models.Issue;

public class IssueService {
	IssueDAO isd = new IssueDAOImpl();

	public Issue getIssue(int id) {
		return isd.getIssue(id);
	}

	public List<Issue> getAllIssues() {
		return isd.getAllIssues();
	}

	public boolean createIssue(Issue i) {
		return isd.createIssue(i);
	}

	public boolean changeIssueStatus(Issue change) {
		return isd.changeIssueStatus(change);
	}

	public boolean deleteIssue(int id) {
		return isd.deleteIssue(id);
	}

}
