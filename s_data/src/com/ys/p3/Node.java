package com.ys.p3;

public class Node<E>{
	
	private E data;
	
	private Node<E> next;
	
	
	public Node(E data) {
		this.data = data;
	}
	
	public void setNext(Node<E> node){
		next = node;
	}
	
	public Node<E> getNext(){
		return next;
	}
	
	public E getData(){
		return data;
	}
	
	
}
