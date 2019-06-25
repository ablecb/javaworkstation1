package com.ys.p6;

public class MyHash<K,V> {
	
	private Node<K,V> [] obj = new Node[10];
	
	private int size;
	
	public boolean push(K k,V v){
		int hash = hash(k);
		Node<K, V> node = new Node<K,V>(k, v);
		Node<K, V> o = obj[hash];
		if(o == null){
			obj[hash] = node;
			size++;
			return true;
		}
		
		while(o.getNext()!= null){
			o = o.getNext();
		}
		o.setNext(node);
		
		return true;
		
	}
	
	public V get(K key){
		
		int hash = hash(key);
		Node<K,V> o = obj[hash];
		
		while(o!= null && !o.getKey().equals(key)){
			o = o.getNext();
		}
		if(o == null){
			return null;
		}
		return o.getValue();
		
	}
	public int hash(K k){
		return (int)k%obj.length;
	}
	
}
