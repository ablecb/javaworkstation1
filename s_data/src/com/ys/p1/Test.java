package com.ys.p1;

public class Test {
	
	
	public static void main(String[] args) {
		
		Books book = new Books();
		
		book.add("a1");
		book.add("a2");
		book.add("a3");
		book.add("a1");
		book.add("a2");
		book.add("a3");
		book.add("a1");
		book.add("a2");
		book.add("a3");
		book.add("a1");
		book.add("a2");
		book.add("a3");
		System.out.println(book.size());
		
		book.add(1,"a4");
		System.out.println(book.size());
		
		Object [] bs = book.getBooks();
		for (Object string : bs) {
			System.out.println(string);
		}
		
		
	}
	
	
	
}
