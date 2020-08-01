package com.yc.thread.d0725;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class uploadServlet {
	public static void main(String[] args) throws IOException {
		ServerSocket server= new ServerSocket(8888);
		Socket socket=server.accept();
		InputStream is =socket.getInputStream();
		File file=new File("C:\\upload");
		if(!file.exists()) {
			file.mkdirs();
		}
		FileOutputStream fos=new FileOutputStream(file+"\\hahaha.txt");
		byte[] buffer = new byte[1024];
		int count;
		while((count=is.read(buffer))>0) {
		
			
				fos.write(buffer,0,count);
		
		}
		socket.getOutputStream().write("上传成功".getBytes());
		fos.close();
		socket.close();
		server.close();
	}
	
	

}
