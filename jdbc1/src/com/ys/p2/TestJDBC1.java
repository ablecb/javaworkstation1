package com.ys.p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJDBC1 {
	
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/my_data","root","123456");
			//创建一个数据操作对象
			Statement sta = conn.createStatement();
			
			/*sta.execute
			("CREATE TABLE m1(id int(4),name varchar(11),sex varchar(11))");*/
			
			sta.execute("INSERT INTO m1(id,name,sex) VALUES(1001,'张三','男')");
			
			sta.execute("INSERT INTO m1(id,name,sex) VALUES(1002,'王麻子','男')");
			sta.execute("INSERT INTO m1(id,name,sex) VALUES(1003,'张丹','女')");
			sta.execute("INSERT INTO m1(id,name,sex) VALUES(1004,'小红','女')");
			sta.execute("INSERT INTO m1(id,name,sex) VALUES(1005,'小明','男')");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
