package com.ys.p5;

public class MyQue<E> {
	
	private Object [] obj = new Object[10];
	
	private int size;
	
	private int rear;
	
	private int first;
	
	public boolean push(E e){
		if(first > obj.length-1){
			throw new RuntimeException("�±�Խ��.....");
		}
		obj[first++] = e;
		size++;
		
		return true;
	}
	
	
	public E poll(){
		
		if(size == 0){
			throw new RuntimeException("�����Ѿ�Ϊ��.....");
		}
		size--;
		return (E)obj[rear++];
		
	}
	
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	
}
