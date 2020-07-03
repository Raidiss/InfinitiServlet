package com.infiniti.models;

public class Issue {
	private int id;
	private String description;
	private String status;

	public Issue(int id, String description, String status) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", description=" + description + ", status=" + status + "]";
	}
	
}
