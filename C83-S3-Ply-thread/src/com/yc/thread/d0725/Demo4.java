package com.yc.thread.d0725;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
	public static void main(String[] args) {
	ProductConsumer pc = new ProductConsumer();
	new Thread() {
		public void run() {
			try {
				pc.produce();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}.start();
	new Thread() {
		public void run() {
			try {
				pc.comsume();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}.start();
	}
}
//��򵥵�������������ģʽ
class ProductConsumer{
	private List<Integer> list = new ArrayList<>();
	public synchronized void produce() throws InterruptedException {
		while(true) {
			
			
			
			if(list.isEmpty()) {
				for(int i=0;i<10;i++) {
					list.add(i);
					System.out.println("������һ����Ʒ"+i);
					Thread.sleep(200);
				}
			}else {
				//֪ͨ�ȴ��̣߳������̣߳�
				notifyAll();
				//�������list��Ϊ�գ���ȴ�
				//��ǰ�̣߳��ȴ��̣߳�
				//һ������ȴ�״̬����ô�����ͷ�������
				wait();
			}
		}
	}
	
	public synchronized void comsume() throws InterruptedException {
		while(true) {
			if(list.isEmpty() == false) {
				for(int i=0;i<10;i++) {
					list.remove(0);
					System.out.println("==============������һ����Ʒ"+i);
					Thread.sleep(200);
				}
			}else {
				//֪ͨ�ȴ��̣߳������̣߳�
				notifyAll();
				//�������list��Ϊ�գ���ȴ�
				//��ǰ�̣߳������̣߳�
				//һ������ȴ�״̬����ô�����ͷ�������
				wait();
			}
		}
	}
	
	
}