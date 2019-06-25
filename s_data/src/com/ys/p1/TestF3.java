package com.ys.p1;

public class TestF3<T> {//B代表一种数据类型的占位符
	
	
	
	public void m1(TestF<? extends Animal> tf){
		
	}
	
	public static void main(String[] args) {
		
		TestF3<String> tf = new TestF3<String>();
		
		tf.m1(new TestF<Dog>());
	}
	
}
