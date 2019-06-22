package com.ys.p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MyServerlet {
	
	public void doGet(HttpServerRequest request,HttpServletResponse response){
		StringBuilder sb = new StringBuilder();
		
		try {
			if(request.isFindSearch()){
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/my_date", "root", "123456");
				PreparedStatement pre = conn.prepareStatement
						("SELECT * FROM m1 WHERE id=?");
				pre.setString(1, request.getParamter("id"));
				ResultSet rs = pre.executeQuery();
				while(rs.next()){
					sb.append("������"+rs.getString("name")+"<br/>");
					sb.append("������"+rs.getString("sex")+"<br/>");
				}
			}else{
				File file = new File("D:/form"+request.getRelPath());
				if(file.exists()){
					if(file.isDirectory()){
						
					}
					FileInputStream fis = new FileInputStream(file);
					int t;
					byte [] b = new byte[1024];
					while((t=fis.read(b))!=-1){
						sb.append(new String(b,0,t));
					}
					System.out.println(sb.toString());
				}else{
					sb.append("�����ʵ���Դ������");
				}
			}
			System.out.println();
			//��ͻ�����ӦHTTP���������
			//��ȡ��ͻ�����Ӧ�����ݵĳ���
			int len = sb.toString().getBytes().length;
			
			PrintWriter pw = response.getWriter();
			
			pw.print("HTTP/1.1 200 OK\r\n");
			pw.print("Content-type: text/html;charset=UTF-8\r\n");
			pw.print("Server: XIAO JU LONG\r\n");
			pw.print("Content-length: "+len+"\r\n");
			pw.print("\r\n");
			pw.print(sb.toString());
			pw.flush();
			pw.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServerRequest request,HttpServletResponse response){
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/my_date", "root", "123456");
			PreparedStatement pre = conn.prepareStatement
					("INSERT INTO m1(id,name,sex) VALUES(?,?,?)");
			pre.setString(1, request.getParamter("id"));
			pre.setString(2, request.getParamter("name"));
			pre.setString(3, request.getParamter("sex"));
			
			pre.executeUpdate();
			
			
			
			String s = "保存数据成功";
			PrintWriter pw = response.getWriter();
			pw.print("HTTP/1.1 200 OK\r\n");
			pw.print("Content-type: text/html;charset=UTF-8\r\n");
			pw.print("Server: XIAO JU LONG\r\n");
			
			pw.print("Content-length: "+s.getBytes().length+"\r\n");
			pw.print("\r\n");
			pw.print(s);
			
			pw.flush();
			
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
