package com.ys.p5;

public class TestM {
	
	
	public static void main(String[] args) {
		
		MyQue2<String> m2 = new MyQue2<String>();
		
		for (int i = 0; i < 10; i++) {
			m2.push("a"+i);
		}
		
		System.out.println(m2.size());
		
		m2.push("a11");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(m2.poll());
		}
		
		
		
		
	}
	
	
}
