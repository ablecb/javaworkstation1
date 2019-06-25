package com.ys.p3;

import com.ys.p3.MyLink3.Itertor;

public class TestLink3 {
	
	
	public static void main(String[] args) {
		
		MyLink3<Integer> m3 = new MyLink3<Integer>();
		
		for (int i = 0; i < 10; i++) {
			m3.add(i);
		}
		
		Itertor it = m3.itertor();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		
		
	}
	
	
	
	
}
