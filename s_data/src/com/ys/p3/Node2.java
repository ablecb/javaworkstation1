package com.ys.p3;

public class Node2<E>{
	
	private E data;
	private int next = -1;
	public Node2(E data) {
		this.data = data;
	}
	public E getData(){
		return data;
	}
	public int getNext(){
		return next;
	}
	public void setNext(int next){
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node2 [data=" + data + ", next=" + next + "]";
	}
	
	
	
}
