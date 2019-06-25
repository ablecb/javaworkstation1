package com.ys.p3;

public class Node4<E>{
	
	private E data;
	private Node4<E> prev;
	private Node4<E> next;
	
	public Node4(E data) {
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node4<E> getPrev() {
		return prev;
	}

	public void setPrev(Node4<E> prev) {
		this.prev = prev;
	}

	public Node4<E> getNext() {
		return next;
	}

	public void setNext(Node4<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node4 [data=" + data + ", prev=" + prev + ", next=" + next + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
