package com.ys.p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

public class My_Cat {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(8888);
			while(true){
				Socket socket = server.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String s;
				String first=null;
				while((s=br.readLine())!=null){
					System.out.println(s);
					if(first == null){
						//��HTTP�������ݵĵ�һ�б�������
						first=s;
					}
					if(s.equals("")){
						break;
					}
				}
				
				//fs数组里面封装一定是用户的请求信息 fs[0] 请求的方法 fs[1] 资源名
				
				String [] fs = first.split(" ");//GET ��Դ�� Э��
				
				for(String string : fs){
					System.out.println(string);
				}
				
				StringBuilder sb = new StringBuilder();
				File file = new File("D:/a.html"+fs[1]);
				
				if(fs[1].contains("?")){
					String [] fs2 = fs[1].split("[?]");
					String param = fs2[1].split("=")[1];
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection
							("jdbc:mysql://localhost:3306/my_date", "root", "123456");
					PreparedStatement pre = conn.prepareStatement
							("SELECT * FROM m1 WHERE id=?");
					pre.setString(1, param);
					ResultSet rs = pre.executeQuery();
					while(rs.next()){
						sb.append("姓名："+rs.getString("name")+"<br/>");
						sb.append("姓名："+rs.getString("sex")+"<br/>");
					}
					
					OutputStream os = socket.getOutputStream();
					PrintWriter pw = new PrintWriter(os);
					pw.print("HTTP/1.1 200 OK\r\n");
					pw.print("Content-type: text/html;charset=UTF-8\r\n");
					pw.print("Server: XIAO JU LONG\r\n");
					//��Ӧ���ݳ���
					pw.print("Content-length: "+sb.toString().getBytes().length+"\r\n");
					pw.print("\r\n");
					pw.print(sb.toString());
					
					pw.flush();
					
					pw.close();
					os.close();
					
				}else{
					
					if(file.exists()){
						FileInputStream fis = new FileInputStream(file);
						int t;
						byte [] b = new byte[1024];
						while((t=fis.read(b))!=-1){
							sb.append(new String(b,0,t));
						}
						System.out.println(sb.toString());
					}else{
						sb.append("�����ʵ���Դ�����ڡ�������");
					}
					System.out.println(sb.toString().getBytes().length);
					//��ͻ�����ӦHTTP���������
					OutputStream os = socket.getOutputStream();
					PrintWriter pw = new PrintWriter(os);
					pw.print("HTTP/1.1 200 OK\r\n");
					pw.print("Content-type: text/html;charset=UTF-8\r\n");
					pw.print("Server: XIAO JU LONG\r\n");
					//��Ӧ���ݳ���
					pw.print("Content-length: "+file.length()+"\r\n");
					pw.print("\r\n");
					pw.print(sb.toString());
					
					pw.flush();
					
					pw.close();
					os.close();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
