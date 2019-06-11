package com.ys.p3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	
	
	public static  Connection  getCon(){
		Connection con = null;
		try {
			FileInputStream fis = new FileInputStream("src/a.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			
			BufferedReader br = new BufferedReader(isr);
			
			String s = null;
			Class.forName(br.readLine());
			con = DriverManager.getConnection
					(br.readLine(),br.readLine(),br.readLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = getCon();
		System.out.println(con);
	}
	
	
}
