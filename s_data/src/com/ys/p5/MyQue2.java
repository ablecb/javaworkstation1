package com.ys.p5;

public class MyQue2<E> {
	
	private Object [] obj = new Object[10];
	
	private int size;
	
	private int rear;
	
	private int first;
	
	public boolean push(E e){
		
		if(isFull()){
			return false;
		}
		if(first>obj.length - 1){
			first = first%obj.length;
		}
		obj[first++] = e;
		size++;
		
		return true;
	}
	
	public E poll(){
		if(size == 0){
			throw new RuntimeException("队列已经为空.....");
		}
		if(rear>obj.length - 1){
			rear = rear%obj.length;
		}
		
		size--;
		return (E)obj[rear++];
		
	}
	
	public boolean isFull(){
		return size == obj.length;
	}
	
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	
}
