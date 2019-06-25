package com.ys.p4;

public class MyStrack<E> {

	private Object[] obj = new Object[10]; 
	
	private int size;
	
	//�涨ջ����ջ�׵Ļ���
	public void push(E data){
		if(size == obj.length){
			throw new RuntimeException("ջ��......");
		}
		obj[size++] = data;
	}
	//ÿһ�δ�ջ����
	public E pop(){
		if(size == 0){
			throw new RuntimeException("ջ��.....");
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
