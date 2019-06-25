package com.ys.p3;

public class MyLink3<E> {
	
	private Node<E> first;
	
	private int size;
	
	private Node<E> last;
	
	public boolean add(E data){
		//��˳��洢ʵ�ֵ�ʱ��  ����ֻ��Ҫ�������ݾ��� ά���±�
		Node<E> node = new Node<E>(data); 
		//��˳��洢  ----- ����Ҫ����Ԫ�ر���  �㻹Ҫά�����Թ�ϵ
		if(first == null){
			size++;
			last = first = node;
			return true;
		}
		//���´�����Ԫ��׷�ӵ�ԭ�������
		last.setNext(node);
		//��ԭ�����lastӦ�ø�����Ųһλ
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
			throw new IndexOutOfBoundsException("�±�Խ��.."+index);
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
			throw new IndexOutOfBoundsException("�±�Խ��.."+index);
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
		//��ɾ��Ԫ�ص�ǰһ��Ԫ��
		Node<E> prev = nodeOf(index-1);
		//�Ǳ�ɾ��Ԫ��
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
		Node<E> prev = first;//��һ��������first
		while(prev.getNext()!= null && !prev.getNext().getData().equals(data)){
			prev = prev.getNext();
		}
		if(prev.getNext()!=null){
			//�Ǳ�ɾ��Ԫ��
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
