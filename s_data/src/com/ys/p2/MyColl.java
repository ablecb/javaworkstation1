package com.ys.p2;

public class MyColl<E>{//Element
	
	private Object [] obj;
	
	private int index;
	
	public MyColl() {
		this(10);
	}
	
	public MyColl(int size){
		obj = new Object[size];
	}
	public boolean add(E e){
		if(index >= obj.length){
			Object [] o2 = new Object[obj.length*2];
			System.arraycopy(obj, 0, o2, 0,obj.length);
		}
		obj[index++] = e;
		return true;
	}
	public void add(int n,E e){
		if(n>index||n<0){
			throw new RuntimeException("插入的位置不对");
		}
		/*if(index >=obj.length){
			throw new RuntimeException("数据已经存满");
		}*/
		if(index >=obj.length){
			Object [] o2 = new Object[obj.length*2];
			for(int i=0;i<index;i++){
				o2[i] = obj[i];
			}
			obj = o2;
		}
		for(int i=this.index;i>n;i--){
			obj[i] = obj[i-1];
		}
		obj[n] = e;
		index++;
	}
	
	public E get(int n){
		if(n > obj.length-1){
			throw new RuntimeException("位置不对");
		}
		return (E) obj[n];
	}
	public int indexOf(E e){
		for (int i = 0; i < index; i++) {
			
			if(obj[i].equals(e)){
				return i;
			}
		}
		return -1;
	}
	
	public boolean remove(int n){
		if(n>index-1){
			throw new RuntimeException("位置不对");
		}
		for(int i=n;i<index;i++){
			obj[i] = obj[i+1];
		}
		index--;
		return true;
	}
	
	public boolean remove(E e){
		
		int n =  indexOf(e);
		if(n == -1){
			return false;
		}
		
		for(int i=n;i<index;i++){
			obj[i] = obj[i+1];
		}
		index--;
		return true;
	}
	
	
	public boolean isEmpty(){
		return index > 0;
	}
	
	public  boolean clear(){
		
		for(int i=0;i<index;i++){
			obj[i] = null;
		}
		return true;
	}
	
	public Object [] getBooks(){
		return obj;
	}
	
	
	
	public int size(){
		return index;
	}
	
	public Itertor itertor(){
		return new Itertor();
	}
	
	
	public class Itertor{
		private int index;
		
		
		public boolean hasNext(){
			return index < size();
		}
		
		public E next(){
			
			return (E) obj[index++];
		}
		
	}
	
	
	
	
}
