package com.yc.thread.d0730;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpServletResponse {
	
	private OutputStream out;
	private int status;
	private String msg;
	private Map<String, String> headerMap = new HashMap<>();
	public HttpServletResponse(OutputStream out) {
		this.out = out;
	}
	
	private CharArrayWriter caw = new CharArrayWriter();

	private PrintWriter pw = new PrintWriter(caw);
	
	public PrintWriter getWriter() {
		// TODO Auto-generated method stub
		return pw;
	}
	
	public void setStatus(int status,String msg) {
		this.status = status;
		this.msg = msg;
	}

	public void flushBuffer() throws IOException {
		out.write(("HTTP/1.1"+status+""+msg+"\n").getBytes());
		out.write(("Content-Type:text/html;charset=utf-8\n").getBytes());
		for(Entry<String,String>entry:headerMap.entrySet()) {
			out.write((entry.getKey()+""+entry.getValue()+"\n").getBytes());
		}
		out.write(("\n").getBytes());
		out.write((caw.toString()).getBytes());
	}
	public void sendRedirect(String rui) {
		setStatus(301,"Redirect");
		headerMap.put("Location", uri)
	}
}
