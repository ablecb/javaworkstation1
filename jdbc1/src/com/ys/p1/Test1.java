package com.ys.p1;

public class Test1 {
	
	
	public static void main(String[] args) {
		
		try {
			//new User();
			Class.forName("com.ys.p1.User");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
