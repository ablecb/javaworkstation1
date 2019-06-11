package com.ys.p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestJDBC5 {
	
	
	public static void add1(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_data",
					"root","123456");
			
			PreparedStatement pre = 
		conn.prepareStatement("INSERT INTO m1(id,name,sex) VALUES(?,?,?)");
			
			for (int i = 0; i < 5; i++) {
				
				pre.setInt(1, i);
				pre.setString(2, "N"+i);
				pre.setString(3, "��");
				//�����ݿ����һ�ν���
				pre.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void add2(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_data",
					"root","123456");
			PreparedStatement pre = 
		conn.prepareStatement("INSERT INTO m1(id,name,sex) VALUES(?,?,?)");
			
			for (int i = 0; i < 5; i++) {
				pre.setInt(1, i);
				pre.setString(2, "N"+i);
				pre.setString(3, "��");
				//��������ӵ���������
				pre.addBatch();
			}
			//�����ݿ����һ�ν���
			pre.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		//add1();
		add2();
	}
	
	
}
