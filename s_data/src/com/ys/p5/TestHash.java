package com.ys.p5;

public class TestHash {
	/*开放定指法*/
	
	public static void main(String[] args) {
		//散列结构
		//将 要存储的数据 通过一个key值计算出数据的位置  
		// key值需要通过一个特定的函数进行一定计算  
		//我们将这个计算位置的函数称之为散列函数
		MyHash<Integer, String> mh = new MyHash<Integer,String>();
		
		mh.put(7,"a");
		mh.put(4,"张三");
		
		
		System.out.println(mh.get(24));
		//System.out.println(mh.get(24));
		
	}
	
	
	
	
}
