package com.ys.p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC3 {
	
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/my_data","root","123456");
			//����һ�����ݲ�������
			Statement sta = conn.createStatement();
			//��ִ��execute�����н��������ʱ ������true Ҫ�����صľ���false
			/*ResultSet rs = sta.executeQuery("SELECT * FROM m1");
			while(rs.next()){
				
				
				
			}*/
			
			int t = sta.executeUpdate("DELETE FROM m1");
			
			System.out.println(t);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
