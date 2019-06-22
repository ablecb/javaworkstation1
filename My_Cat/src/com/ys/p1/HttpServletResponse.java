package com.ys.p1;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpServletResponse {
	
	private OutputStream outPutStream;
	
	private PrintWriter writer;
	
	public HttpServletResponse(Socket socket){
		
		try {
			outPutStream = socket.getOutputStream();
			writer = new PrintWriter(outPutStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public OutputStream getOuptStream(){
		return outPutStream;
	}
	
	public PrintWriter getWriter(){
		return writer;
	}
	
}
