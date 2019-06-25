package com.ys.p4;

import java.util.ArrayList;
import java.util.Scanner;

public class TestStack3 {
	
	public static void main(String[] args) {
		String a = new Scanner(System.in).nextLine();//231-*
		
		ArrayList<Character> arry = new ArrayList<Character>();
		
		MyStrack<Character> stack = new MyStrack<Character>();
		String na="";
		for (int i = 0; i < 10; i++) {
			char c = (char) ('0'+i);
			arry.add(c);
		}
		for (int i = 0; i <a.length(); i++) {
			char c = a.charAt(i);
			if(arry.contains(c)){
				na+=c;
			}else{
				if(stack.isEmpty()){
					stack.push(c);
					continue;
				}
				if(c == '('){
					stack.push(c);
					continue;
				}
				//��ջ֮ǰ��ŷ���λ  -
				char d = stack.pop();//*
				if(d=='('){
					stack.push(d);
					stack.push(c);
					continue;
				}
				if(c==')'){
					na+=d;
					char f;
					while((f = stack.pop())!='('){
						na+=f;
					}
				}else{
					//c��������Ҫ�ȶԵķ���λ  +
					int a1 = (d == '+'||d=='-') ? 0 : 1;
					int a2 = (c == '+'||c=='-') ? 0 : 1;
					if(a1>=a2){
						na+=d;
						stack.push(c);
					}else if(a1<a2){
						stack.push(d);
						stack.push(c);
					}
				}
			}
			if(i == a.length() - 1){
				while(!stack.isEmpty()){
					na+=stack.pop();
				}
			}
			
		}
		MyStrack<Integer> ms = new MyStrack<Integer>();
		
		for (int i = 0; i < na.length(); i++) {
			char c = na.charAt(i);
			if(arry.contains(c)){
				ms.push(Integer.parseInt(c+""));
			}else{
				int a1 = ms.pop();
				int a2 = ms.pop();
				switch (c) {
					case '+':
						ms.push(a2+a1);
						break;
					case '-':
						ms.push(a2-a1);
						break;
					case '*':
						ms.push(a2*a1);
						break;
					case '/':
						ms.push(a2/a1);
						break;
				}
				
				
			}
			
			if(i == na.length()-1){
				System.out.println(ms.pop());
			}
			
			
			
		}
		
		
	}
	
	
	
}
