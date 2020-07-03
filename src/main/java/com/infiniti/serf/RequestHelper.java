package com.infiniti.serf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infiniti.controllers.IssueController;
import com.infiniti.controllers.PlanController;
import com.infiniti.controllers.UserController;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		System.out.println("URL: " + url + "\nURI: " + uri);

		/*
		 * this switch handle various requests
		 */
		switch (uri) {

		case "/InfinitiServlet/getPlan.do": {
			PlanController.getPlan(request, response);
			break;
		}

		case "/InfinitiServlet/allPlans.do": {
			PlanController.getAllPlans(request, response);
			break;
		}

		case "/InfinitiServlet/addPlan.do": {
			PlanController.addPlan(request, response);
			break;
		}

		case "/InfinitiServlet/updatePlan.do": {
			PlanController.updatePlan(request, response);
			break;
		}

		case "/InfinitiServlet/deletePlan.do": {
			PlanController.deletePlan(request, response);
			break;
		}

		case "/InfinitiServlet/getIssue.do": {
			IssueController.getIssue(request, response);
			break;
		}

		case "/InfinitiServlet/allIssues.do": {
			IssueController.getAllIssues(request, response);
			break;
		}

		case "/InfinitiServlet/createIssue.do": {
			IssueController.createIssue(request, response);
			break;
		}

		case "/InfinitiServlet/changeIssueStatus.do": {
			IssueController.changeIssueStatus(request, response);
			break;
		}

		case "/InfinitiServlet/deleteIssue.do": {
			IssueController.deleteIssue(request, response);
			break;
		}
		
		case "/InfinitiServlet/getUser.do": {
			UserController.getUser(request, response);
			break;
		}

		case "/InfinitiServlet/allUsers.do": {
			UserController.getAllUsers(request, response);
			break;
		}

		case "/InfinitiServlet/addUser.do": {
			UserController.addUser(request, response);
			break;
		}

		case "/InfinitiServlet/updateUser.do": {
			UserController.updateUser(request, response);
			break;
		}

		case "/InfinitiServlet/deleteUser.do": {
			UserController.deleteUser(request, response);
			break;
		}

		default: {
			response.sendError(451, "Get off my lawn!");
			break;
		}

		}

	}

}
