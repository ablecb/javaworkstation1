package com.ys.p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC4 {
	
	
	public static void sel1(String id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_data",
					"root","123456");
			Statement sta = conn.createStatement();
			
			ResultSet rs = sta.executeQuery("SELECT * FROM m1 WHERE id="+id);
			
			while(rs.next()){
				
				System.out.println(rs.getInt("id")+"      "+rs.getString("name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sel2(String id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_data",
					"root","123456");
			
			//创建一个预处理对象
			PreparedStatement pre = 
					conn.prepareStatement("SELECT * FROM m1 WHERE id='1002 AND name='");
			
			//pre.setString(1, id);
			
			
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()){
				
				System.out.println(rs.getInt("id")+"      "+rs.getString("name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		//sel1("1002  OR id <> 1002");
		sel2("1002 AND id<>1002");
	}
	
	
}
