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
			//创建一个数据操作对象
			Statement sta = conn.createStatement();
			//当执行execute方法有结果集返回时 它返回true 要不返回的就是false
			boolean b = sta.execute("SELECT * FROM m1");
			
			if(b){
				//获取查询的结果集
				ResultSet rs = sta.getResultSet();
				//判断结果集还有没有下一行数据
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
