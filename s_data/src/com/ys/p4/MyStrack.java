package com.ys.p4;

public class MyStrack<E> {

	private Object[] obj = new Object[10]; 
	
	private int size;
	
	//规定栈顶和栈底的划分
	public void push(E data){
		if(size == obj.length){
			throw new RuntimeException("栈满......");
		}
		obj[size++] = data;
	}
	//每一次从栈顶出
	public E pop(){
		if(size == 0){
			throw new RuntimeException("栈空.....");
		}
		return (E) obj[--size];
	}
	
	
	public int size(){
		return size;
	}
	
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	
}
