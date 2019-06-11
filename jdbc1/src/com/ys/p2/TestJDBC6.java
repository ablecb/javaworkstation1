package com.ys.p2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC6 {
	
	
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
				pre.setString(3, "男");
				//跟数据库进行一次交互
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
				pre.setString(3, "男");
				//将任务添加到批处理中
				pre.addBatch();
			}
			//跟数据库进行一次交互
			pre.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void add3(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_data",
					"root","123456");
			PreparedStatement pre = 
		conn.prepareStatement("INSERT INTO m1(id,name,sex,head) VALUES(?,?,?,?)");
			
			pre.setInt(1,8);
			pre.setString(2,"小黄");
			pre.setString(3, "女");
			
			File file = new File("D:/add.png");
			
			FileInputStream fis = new FileInputStream(file);
			
			pre.setBinaryStream(4, fis, file.length());
			
			pre.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void read1(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_data",
					"root","123456");
			PreparedStatement pre = 
		  conn.prepareStatement("SELECT * FROM m1 WHERE id=8");
			ResultSet rs = pre.executeQuery();
			while(rs.next()){
				Blob b = rs.getBlob("head");
				InputStream is = b.getBinaryStream();
				FileOutputStream fos = new FileOutputStream("D:/a.png");
				int t ;
				while((t = is.read())!=-1){
					fos.write(t);
				}
				fos.close();
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//add1();
		//add2();
		//add3();
		read1();
	}
	
	
}
