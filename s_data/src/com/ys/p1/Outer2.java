package com.ys.p1;

public class Outer2 {
	
	private static String out1;
	
	
	
	public void getInner(){
		new Inner();
	}
	
	
	
	
	static class Inner{
		
		
		
		public void m1(){
			System.out.println(out1);
		}
		
	}
	
	
	
}
