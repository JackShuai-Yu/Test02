package com.yc.thread.d0725;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class uploadClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		FileInputStream fis=new FileInputStream("D:\\new\\hahaha.txt");
		Socket socket=new Socket("127.0.0.1",8888);
		OutputStream os=socket.getOutputStream();
		byte[] buffer = new byte[1024];
		int count;
		while((count=fis.read(buffer))>0) {
		
			
				os.write(buffer,0,count);
		
		}
		InputStream is=socket.getInputStream();
		while((count=is.read(buffer))>0) {
			
			
			System.out.println(new String(buffer,0,count));
	
	}
		System.out.println("文件上传成功");
		fis.close();
		socket.close();
		
	}

}
