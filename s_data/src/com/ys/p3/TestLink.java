package com.ys.p3;

import com.ys.p3.MyLink.Itertor;

public class TestLink {
	
	
	public static void main(String[] args) {
		MyLink<String> m1 = new MyLink<String>();
		for (int i = 0; i < 10; i++) {
			m1.add("a"+i);
		}
		
		System.out.println(m1.size());
		System.out.println(m1.get(9));
		
		m1.add(2, "a2222");
		
		System.out.println(m1.get(3));
		
		System.out.println(m1.size());
		
		
		Itertor it = m1.itertor();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("----------------");
		
		m1.remove(2);
		
		System.out.println(m1.get(2));
		
		m1.remove("a3");
		
		System.out.println("----------------");
		Itertor it2 = m1.itertor();
		
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		
		
	}
	
	
	
	
}
