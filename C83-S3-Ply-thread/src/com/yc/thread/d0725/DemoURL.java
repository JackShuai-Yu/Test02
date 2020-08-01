package com.yc.thread.d0725;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DemoURL {
	public static void main(String[] args) throws IOException {
			URL url = new URL("http://www.hyycinfo.com");
			
			
			System.out.println(url.getProtocol());//获取url中的协议
			System.out.println(url.getPort());//获取url中的端口
			System.out.println(url.getPath());//获取url中的资源路径
			System.out.println(url.getHost());//获取url中的域名
			System.out.println(url.getFile());//获取url中的资源名
			System.out.println(url.getQuery());//获取url中的地址中参数
			URLConnection conn = url.openConnection();
			
			System.out.println(conn.getLastModified());//目标资源的最后修改时间
			System.out.println(conn.getContentLengthLong());//目标资源的大小
			System.out.println(conn.getContentType());//目标资源的类型js html jpg...
			
			System.out.println("============================");
			
			InputStream in = conn.getInputStream();
			byte[] buffer = new byte[1024];
			int count;
			while((count=in.read(buffer))>0) {
				System.out.println(new String(buffer,0,count));
			}
			in.close();
	}
}
