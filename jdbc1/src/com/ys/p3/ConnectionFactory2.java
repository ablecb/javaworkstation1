package com.ys.p3;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConnectionFactory2 {
	
	private static String driver;
	private static String pass;
	private static String user;
	private static String url;
	
	
	static{
		
		
		try {
			SAXReader sax = new SAXReader();
			
			Document dom = sax.read(new File("src/jdbc.xml"));
			
			Element root = dom.getRootElement();
			driver = root.elementText("driver");
			url = root.elementText("url");
			pass = root.elementText("pass");
			user = root.elementText("user");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static  Connection  getCon(){
		Connection con = null;
		try {
			
			/*
			 *List<Element> list = root.elements();

			 * for (Element e1 : list) {
				
				if(e1.getName().equals("driver")){
					driver = e1.getText();
				}else if(e1.getName().equals("url")){
					url = e1.getText();
				}else if(e1.getName().equals("pass")){
					pass = e1.getText();
				}else if(e1.getName().equals("user")){
					user = e1.getText();
				}	
			}*/
			
			Class.forName(driver);
			con = DriverManager.getConnection
					(url,user,pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = getCon();
		System.out.println(con);
	}
	
	
}
