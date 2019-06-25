package com.ys.p1;

public class Outer {
	
	private String out;
	
	public Outer() {
		
	}
	public Outer(String out){
		this.out = out;
	}
	public void createInner2(){
		new Inner2();
	}
	public Inner getInner(){
		
		return this.new Inner();
	}
	class Inner{
		
		private String in1;
		
		public Inner() {
			
		}
		
		public Inner(String in1) {
			this.in1 = in1;
		}
		
		public void mIn1(){
			System.out.println(in1);
		}
		
		public void m2(){
			System.out.println("Õ‚≤ø¿‡£∫"+out);
		}
		
	}
	
	private class Inner2{
		
	}
	
	
	
	
}
