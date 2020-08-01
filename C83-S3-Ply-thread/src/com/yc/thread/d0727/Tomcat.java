package com.yc.thread.d0727;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tomcat {
	public static void main(String[] args) throws IOException {
		ServerSocket tomcat = new ServerSocket(8080);
		System.out.println("tomcat服务器启动成功，监听端口：8080");
		boolean running = true;
		Socket socket = tomcat.accept();
		while(running) {
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
						
						
						String[] lines = requestText.split("\\n");
						String[] requestLines = lines[0].split("\\s");
						String webpath = requestLines[1];
						String contentType;
						
						int statusCode = 200;
						String path = "‪D:\\桌面\\源码和资料\\code\\07_HTML\\05.表单.html"+webpath;
						File file = new File(path);
						if(!file.exists()) {
							statusCode=404;
							path="‪D:\\桌面\\源码和资料\\code\\07_HTML\\04.表单.html";
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
					socket.close();
					
				}catch (Exception e) {
					e.printStackTrace();
					}
				}
			}.start();
	
		}
		tomcat.close();
	}

}
