package com.ys.p3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC1 {
	
	
	public void add(){
		
		try {
			Connection conn = ConnectionFactory.getCon();
			
			Statement sta = conn.createStatement();
			
			sta.executeUpdate("INSERT INTO m1(id,name) VALUES(9,'ÍõÂé×Ó')");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void sel(){
		
		try {
			Connection conn = ConnectionFactory.getCon();
			
			Statement sta = conn.createStatement();
			
			sta.executeQuery("SELECT * FORM m1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		try {
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
