package com.ys.p1;

import java.util.HashMap;
import java.util.Map;

public class HttpServerRequest {
	
	private String method;//客户端请求的方式
	private String relPath;//
	private Map<String,String> paramsMap=new HashMap<String,String>();
	private boolean findSearch;
	
	public HttpServerRequest(String first){
		String [] fs = first.split(" ");//GET ��Դ�� Э��
		
		method = fs[0];
		relPath = fs[1];
		if(fs[1].contains("?")){//判断用户的请求头有没有传递查询数据
			findSearch =true;
			String[] params = fs[1].split("[?]");
			//index.html?id=1001&name=
			relPath = params[0];
			
			String [] requestParams = params[1].split("&");
			//id=?
			for(String ss : requestParams){
				String [] sp = ss.split("=");
				paramsMap.put(sp[0], sp[1]);
			}
			
		}
	}
	
	public void setData(String adate){
		String [] requestParams = adate.split("&");
		for(String ss : requestParams){
			String [] sp = ss.split("=");
			paramsMap.put(sp[0], sp[1]);
		}
	}
	
	public String getMethod(){
		return method;
	}
	
	public String getRelPath(){
		return relPath;
		
	}
	
	public String getParamter(String name){//name 客户端传递的参数的名字
		return paramsMap.get(name);
	}
	
	public boolean isFindSearch(){
		return findSearch;
	}
	
}
