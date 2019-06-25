package com.ys.p1;

import com.ys.p1.Outer.Inner;

public class TestInner {
	
	
	public static void main(String[] args) {
		
		Outer out = new Outer();
		
		Inner it = out.new Inner();
		
		
		Inner it2 = out.new Inner("abc");
		
		it2.mIn1();
		
		System.out.println("-------------------------");
		
		Outer out2 = new Outer("out");
		Inner it3 = out2.new Inner();
		
		it3.m2();
		
		System.out.println("------------------------");
		
		Outer out4 = new Outer();
		
		
		Inner it4 = out4.getInner();
		
		
	}
	
	
}
