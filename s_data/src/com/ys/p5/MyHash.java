package com.ys.p5;

public class MyHash<K,V> {

	
	private Node<K, V> [] obj = new Node[10];
	
	private int size;
	
	public void put(K k,V v){
		int hash  = hash(k);
		Node<K, V> node = new Node<K,V>(k,v);
		while(obj[hash]!=null){
			hash++;
		}
		obj[hash] = node;
		size++;
		
	}
	
	public V get(K k){
		int hash = hash(k);
		Node<K,V> node = obj[hash];
		while(node!= null && !node.getKey().equals(k)){
			node = obj[++hash];
		}
		return node == null ?null :(V) obj[hash].getValue();
	}
	
	/*public boolean remove(K k){
		
	}*/
	
	public int hash(K k){
		
		return (int) k%obj.length;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
}
