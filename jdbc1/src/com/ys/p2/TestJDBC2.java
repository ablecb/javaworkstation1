package com.ys.p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC2 {
	
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver111111111111");
			Connection conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/my_data","root","123456");
			//����һ�����ݲ�������
			Statement sta = conn.createStatement();
			//��ִ��execute�����н��������ʱ ������true Ҫ�����صľ���false
			boolean b = sta.execute("SELECT * FROM m1");
			
			if(b){
				//��ȡ��ѯ�Ľ����
				ResultSet rs = sta.getResultSet();
				//�жϽ��������û����һ������
				while(rs.next()){
					
					System.out.println(rs.getInt(1)+"----"
					+rs.getString(2)+"-----"+rs.getString(3));
					
					System.out.println(rs.getInt("id")+"----"+
					rs.getString("name")+"----"+rs.getString("sex"));
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
