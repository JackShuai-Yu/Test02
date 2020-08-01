package com.yc.thread.d0730;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.yc.thread.d0729.HelloServlet;
import com.yc.thread.d0729.Servlet;

public class Tomcat {
	private HashMap<String, Servlet> servletMap;
	private void startup() throws IOException {
	servletMap = new HashMap<>();
	servletMap.put("/photo/hello", new HelloServlet());
	servletMap.put("/", new ToIndexServlet());
	
	
	
	
	ServerSocket tomcat = new ServerSocket(8080);
	System.out.println("tomcat服务器启动成功，监听端口：8080");
	boolean running = true;
	while(running) {
	Socket socket = tomcat.accept();
	new Thread() {
		public void run() {
			try {
				System.out.println("接收到请求");
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
				byte[] buffer = new byte[1024];
				int count;
				count= in.read(buffer);
				if(count>0) {
					String requestText = new String(buffer,0,count);
					System.out.println(requestText);
					HttpServletRequest request = buildRequest(requestText);
					String uri = request.getRequestURI();
					Servlet servlet = servletMap.get(uri);
					if(servlet!=null) {
						servlet.service(request, response);
					}else {
						processStaticReuqest(request,out);
						}
					}
				socket.close();
				
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
}.start();
}
tomcat.close();
}
	private void shutdown() {
		
	}
	
	private HttpServletRequest buildRequest(String requestText) {
		return new HttpServletRequest(requestText);
		}
	
	public static void main(String[] args) throws IOException{
		new Tomcat().startup();
	}
	
	public void processStaticReuqest(HttpServletRequest request,OutputStream out) {
		String webpath = request.getRequestURI();
		String contentType;
		int statusCode = 200;
		String path = ""+webpath;
		File file = new File(path);
		if(!file.exists()) {
			statusCode=404;
			path="";
		}
		if(webpath.endsWith(".js")) {
			contentType = "application/javascript; charset=utf-8";
		}else if(webpath.endsWith(".css")){
			contentType="text/css;charset=utf-8";
		}else {
			contentType="html/css;charset=utf-8";
		}
		
		out.write(("HTTP/1.1"+statusCode+"K\n").getBytes());
		
		out.write(("Content-type:"+contentType+"\n").getBytes());
		
		out.write("\n".getBytes());
		
		//out.write("<h1>Hello World<h1>".getBytes());

		FileInputStream fis = new FileInputStream(path);
		while((count=fis.read(buffer))>0) {
			out.write(buffer,0,count);
		}
		
		fis.close();
	}
	
	}