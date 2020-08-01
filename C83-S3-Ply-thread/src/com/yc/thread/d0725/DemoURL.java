package com.yc.thread.d0725;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DemoURL {
	public static void main(String[] args) throws IOException {
			URL url = new URL("http://www.hyycinfo.com");
			
			
			System.out.println(url.getProtocol());//��ȡurl�е�Э��
			System.out.println(url.getPort());//��ȡurl�еĶ˿�
			System.out.println(url.getPath());//��ȡurl�е���Դ·��
			System.out.println(url.getHost());//��ȡurl�е�����
			System.out.println(url.getFile());//��ȡurl�е���Դ��
			System.out.println(url.getQuery());//��ȡurl�еĵ�ַ�в���
			URLConnection conn = url.openConnection();
			
			System.out.println(conn.getLastModified());//Ŀ����Դ������޸�ʱ��
			System.out.println(conn.getContentLengthLong());//Ŀ����Դ�Ĵ�С
			System.out.println(conn.getContentType());//Ŀ����Դ������js html jpg...
			
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
