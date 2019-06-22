package com.ys.p1;

public class User {
	
	private int id1;
	private String name;
	private int age;
	
	public void setId(int id1) {
		this.id1 = id1;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id1 + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
