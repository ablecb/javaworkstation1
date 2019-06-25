package com.ys.p3;

public class MyLink4<E> {
	
	private Node4<E> first;
	
	private int size;
	
	private Node4<E> last;
	
	public boolean add(E data){
		Node4<E> node = new Node4<E>(data);
		if(first== null){
			first =last = node;
			size++;
			return true;
		}
		last.setNext(node);
		node.setPrev(last);
		last = node;
		first.setPrev(last);
		last.setNext(first);
		size++;
		return true;
	}
	
	public boolean add(int index,E data){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("indexofBuounds£º   "+index);
		}
		Node4 node = new Node4<E>(data);
		Node4<E> rnode = first;
		int count = 0;
		while(count < index){
			rnode = rnode.getNext();
			count++;
		}
		Node4<E> prev = rnode.getPrev();
		prev.setNext(node);
		node.setPrev(prev);
		node.setNext(rnode);
		rnode.setPrev(node);
		size++;
		return true;
	}
	
	
	
	
	
}
