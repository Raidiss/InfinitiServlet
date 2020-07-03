package com.infiniti.models;

public class Plan {
	
	private int id;
	private int speed;
	private String name;
	private float price;
	private String description;
	
	public Plan(int id, int speed, String name, float price, String description) {
		super();
		this.id = id;
		this.speed = speed;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Plan [speed=" + speed + ", name=" + name + ", price=" + price + ", description=" + description + ", id="
				+ id + "]";
	}

}
