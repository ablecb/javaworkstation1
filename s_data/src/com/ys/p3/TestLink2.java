package com.ys.p3;

public class TestLink2 {
	
	
	public static void main(String[] args) {
		MyLink2<Integer> m1 = new MyLink2<Integer>();
		
		Object [] obj1 = m1.getObj();
		for (Object object : obj1) {
			System.out.println(object);
		}
		System.out.println("--------------------------");
		
		for (int i = 0; i < 10; i++) {
			m1.add(10+i);
		}
		
		Object [] obj2 = m1.getObj();
		for (Object object : obj2) {
			System.out.println(object);
		}
		
		
		
		
		
		
	}
	
	
	
	
}
