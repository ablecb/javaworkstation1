package com.ys.p1;

public class TestF<B> {//B����һ���������͵�ռλ��
	private B b;
	
	public void m1(B a){
		b = a;
	}
	
	public B getB(){
		return b;
	}
	public static void main(String[] args) {
		
		TestF<String> tf = new TestF<String>();
		
		tf.m1("abc");
		
		String s = tf.getB();
		
		System.out.println(s);
		
	}
	
}
