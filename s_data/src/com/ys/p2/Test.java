package com.ys.p2;

import java.util.ArrayList;

import com.ys.p2.MyColl.Itertor;

public class Test {
	
	
	public static void main(String[] args) {
		//����˳��洢���Խṹ��һ��˳���
		new ArrayList();
		
		
		MyColl<Student> m1 = new MyColl<Student>();
		
		for (int i = 0; i < 10; i++) {
			m1.add(new Student("С��"+i));
		}
		Itertor it = m1.itertor();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	
}
