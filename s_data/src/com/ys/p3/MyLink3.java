package com.ys.p3;

public class MyLink3<E> {
	
	private Node<E> first;
	
	private int size;
	
	private Node<E> last;
	
	public boolean add(E data){
		//用顺序存储实现的时候  我们只需要保存数据就行 维护下标
		Node<E> node = new Node<E>(data); 
		//非顺序存储  ----- 不仅要将该元素保存  你还要维护线性关系
		if(first == null){
			size++;
			last = first = node;
			return true;
		}
		//将新创建的元素追加到原链表最后
		last.setNext(node);
		//将原链表的last应用给后面挪一位
		last = node;
		last.setNext(first);
		
		size++;
		return true;
	}
	
	
	public E get(int index){//3
		
		Node<E> node = nodeOf(index);
		
		return node.getData();
	}
	
	public Node<E> nodeOf(int index){
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("下标越界.."+index);
		}
		Node<E> node = first;
		int count = 0;
		while(count < index){//3
			node = node.getNext();
			count++;
		}
		return node;
	}
	
	public boolean add(int index,E data){//3---6
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("下标越界.."+index);
		}
		/*if(index == size){
			return add(data);
		}*/
		Node<E> node = new Node<E>(data);
		Node<E> prev = nodeOf(index-1);
		node.setNext(prev.getNext());
		prev.setNext(node);
		size++;
		return true;
	}
	
	
	public E remove(int index){//0
		if(index == 0){
			E data = first.getData();
			Node<E> next = first.getNext();
			first.setNext(null);
			first = next;
			size--;
			return data;
		}
		//被删除元素的前一个元素
		Node<E> prev = nodeOf(index-1);
		//是被删除元素
		Node<E> next = prev.getNext();
		
		prev.setNext(next.getNext());
		
		next.setNext(null);
		
		return next.getData();
		
	}
	
	public boolean remove(E data){
		if(first.getData().equals(data)){
			Node<E> next = first.getNext();
			first.setNext(null);
			first = next;
			size--;
			return true;
		}
		Node<E> prev = first;//上一个结点就是first
		while(prev.getNext()!= null && !prev.getNext().getData().equals(data)){
			prev = prev.getNext();
		}
		if(prev.getNext()!=null){
			//是被删除元素
			Node<E> next = prev.getNext();
			prev.setNext(next.getNext());
			next.setNext(null);
			size--;
			return true;
		}
		return false;
	}
	
	public int size(){
		return size;
	}
	
	
	public Itertor itertor(){
		return new Itertor();
	}
	
	
	public class Itertor{
		
		private int size;
		
		private Node<E> node = first;
		
		public boolean hasNext(){
			
			if(size == size()){
				return false;
			}
			
			return true;
		}
			
		public E next(){
			
			E e = node.getData();
			node = node.getNext();
			size++;
			return e;
		}
		
		
	}
	
	
}
