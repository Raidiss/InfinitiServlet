package com.infiniti.dao;

import java.util.List;

import com.infiniti.models.Issue;


public interface IssueDAO {
	
	public Issue getIssue(int id);
	public List<Issue> getAllIssues();
	public boolean createIssue(Issue i);
	public boolean changeIssueStatus(Issue change);
	public boolean deleteIssue(int id);

}
