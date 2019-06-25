package com.ys.p1;

public class Books {

	private Object [] obj; 
	//增   删  改   查  操作
	private int index;
	
	
	public Books(){
		this(10);
	}
	
	public Books(int size){
		obj= new String [size];
	}
	/*public boolean  add(String s1){
		
		if(index >= obj.length){
			return false;
		}
		obj[index++] = s1;
		return true;
	}*/
	public boolean add(String s1){
		if(index >= obj.length){
			Object [] o2 = new Object[obj.length*2];
			System.arraycopy(obj, 0, o2, 0,obj.length);
		}
		obj[index++] = s1;
		return true;
	}
	public void add(int n,String s1){
		
		if(n>index-1){
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
		obj[n] = s1;
		index++;
	}
	
	public Object get(int n){
		if(n > obj.length-1){
			throw new RuntimeException("位置不对");
		}
		return obj[n];
	}
	public int indexOf(String s1){
		for (int i = 0; i < index; i++) {
			
			if(obj[i].equals(s1)){
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
	
	public boolean remove(String s1){
		
		int n =  indexOf(s1);
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
	
	
	
	
}
