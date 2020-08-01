package com.yc.thread.d0725;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/*
 * URL��˫��ģʽ==>web
 * Socketȫ˫��ģʽ==>QQ
 * */

//�������ˣ�ֻ��������ǰ�Ľз�
public class DemoServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("�����������ɹ�������8888�˿�");
		//���ܿͻ��˵�����
		//IO�����ᵼ�³����ٴζ������ͻ����ӳɹ������������ͬʱ����Socket(�׽��ֶ���)
		Socket socket = server.accept();
		//�ҵĵ�ַ
		InetAddress myAddress = socket.getInetAddress();
		SocketAddress otherAddress = socket.getRemoteSocketAddress();
		System.out.println("�ҵĵ�ַ��"+myAddress);
		System.out.println("�ͻ��˵ĵ�ַ��"+otherAddress);
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		Scanner sc = new Scanner(System.in);
		new Thread() {
			public void run() {
				byte[] buffer = new byte[1024];
				int count;
				while(true) {
					try {
						count = in.read(buffer);
						System.out.println("��˵"+new String(buffer,0,count));
					}catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		}.start();
		new Thread() {
			public void run() {
				byte[] buffer = new byte[1024];
				int count;
				while(true) {
					try {
						//��ظ��ͻ���һ����Ϣ
						System.out.println("��˵");
						out.write(sc.nextLine().getBytes());
					}catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		}.start();
	}
}
