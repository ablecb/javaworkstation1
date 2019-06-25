package com.ys.p4;

import java.util.ArrayList;

public class TestStack {
	
	public static void main(String[] args) {
		String a = "2*(3-1)";//231-*
		
		ArrayList<Character> arry = new ArrayList<Character>();
		
		MyStrack<Character> stack = new MyStrack<Character>();
		
		for (int i = 0; i < 10; i++) {
			char c = (char) ('0'+i);
			arry.add(c);
		}
		for (int i = 0; i <a.length(); i++) {
			char c = a.charAt(i);
			if(arry.contains(c)){
				System.out.print(c);
				
				if(i == a.length() - 1){
					while(!stack.isEmpty()){
						System.out.print(stack.pop());
					}
				}
				
			}else{
				if(stack.isEmpty()){
					stack.push(c);
					continue;
				}
				//是栈之前存放符号位  -
				char d = stack.pop();
				//c是现在正要比对的符号位  +
				int a1 = (d == '+'||d=='-') ? 0 : 1;
				int a2 = (c == '+'||c=='-') ? 0 : 1;
				if(a1>=a2){
					System.out.print(d);
					stack.push(c);
				}else if(a1<a2){
					stack.push(d);
					stack.push(c);
				}
			}
			
		}
		
	}
	
	
	
}
