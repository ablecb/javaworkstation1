package com.ys.p3;

public class MyLink2<E> {
	
	private Node2<E> [] obj = new Node2[10];
	private int size ; 
	//�������������׸�Ԫ��
	private int first = -1;
	//�������������һ��
	private int lastIndex = 0;
	
	public boolean add(E data){
		Node2<E> node = new Node2<E>(data);
		if(first == -1){
			first = lastIndex;
			obj[lastIndex++] = node;
			size++;
			return true;
		}
		while(obj[lastIndex]!=null){
			lastIndex++;
		} 
		int t  = first;
		while(obj[t].getNext()!=-1){
			t = obj[t].getNext();
		}
		obj[lastIndex] = node;
		obj[t].setNext(lastIndex); 
		size++;
		return true;
	}
	
	public boolean remove(int index){//3
		if(index  == 0 ){
			int t = obj[first].getNext();
			obj[first] = null;
			first = t;
			lastIndex = 0;
			return true;
		}
		int count = 0;
		int n = first;
		while(count < index-1){
			n = obj[n].getNext();
			count++;
		}
		//��ɾ��Ԫ�ص�С��
		int r = obj[n].getNext();
		obj[n].setNext(obj[r].getNext());
		obj[r] = null;
		lastIndex = r;
		return true;
	}
	
	
	
	
	
	public Object [] getObj(){
		return obj;
	}
	
	
	
}
