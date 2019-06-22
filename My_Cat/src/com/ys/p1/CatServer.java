package com.ys.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.Messaging.SyncScopeHelper;

public class CatServer {
	
	public static void main(String[] args) {
			
		try {
			ServerSocket server = new ServerSocket(8888);
			while(true){
				Socket socket = server.accept();
				
				InputStream is = socket.getInputStream();
				String s;
				String first = null;
				HttpServerRequest request = null;
				int len = 0;
				int t = -1;
				String sdata = null;
				
				StringBuilder sb = new StringBuilder();
				
				while((t = is.read())!=-1){
					char c = (char)t;
					sb.append(c);
					if(c =='\r'){
						c = (char)is.read();
						sb.append(c);
						if(c == '\n'){
							if(first == null){
								first = sb.toString();
								request = new HttpServerRequest(first);
							}else{
								c = (char)is.read();
								sb.append(c);
								if(c == '\r'){
									c = (char)is.read();
									sb.append(c);
									
									if(c == '\n'){
										String s1 = sb.toString();
										
										if(request.getMethod().equals("GET")){
											break;
										}
										System.out.println(s1);
										//Post请求
										String [] rs = s1.split("\r\n");
										
										for(String str : rs){
											if(str.contains("Content-Length")){
												len = Integer.parseInt(str.substring(str.indexOf(":")+1).trim());
												break;
											}
										}
										System.out.println("len="+len);
										byte [] b = new byte[len];
										is.read(b);
										sdata = new String(b);
										
										System.out.println(sdata);
										System.out.println(sdata.length());
									}
								}
							}
						}
					
					}
				}
				System.out.println(sdata);
				
				HttpServletResponse response = new HttpServletResponse(socket);
				if(request.getMethod().equals("GET")){
					new MyServerlet().doGet(request, response);
				}else{
					request.setData(sdata);
					new MyServerlet().doPost(request, response);
				}
				System.out.println("aaaaaaaaaaa");
				socket.close();
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
