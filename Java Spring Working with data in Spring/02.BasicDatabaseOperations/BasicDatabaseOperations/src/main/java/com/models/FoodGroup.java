package com.models;

public class FoodGroup {
	int id;
	String name;
	String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String TalkAboutYourSelf()
	{
		return "Food name: " + name + " Food group description: " + description + "(Id:" + id + ")";
	}
}
