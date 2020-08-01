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
//最简单的生产者消费者模式
class ProductConsumer{
	private List<Integer> list = new ArrayList<>();
	public synchronized void produce() throws InterruptedException {
		while(true) {
			
			
			
			if(list.isEmpty()) {
				for(int i=0;i<10;i++) {
					list.add(i);
					System.out.println("生产了一个产品"+i);
					Thread.sleep(200);
				}
			}else {
				//通知等待线程（消费线程）
				notifyAll();
				//如果集合list不为空，则等待
				//当前线程（等待线程）
				//一旦进入等待状态，那么将会释放锁对象
				wait();
			}
		}
	}
	
	public synchronized void comsume() throws InterruptedException {
		while(true) {
			if(list.isEmpty() == false) {
				for(int i=0;i<10;i++) {
					list.remove(0);
					System.out.println("==============消费了一个产品"+i);
					Thread.sleep(200);
				}
			}else {
				//通知等待线程（生产线程）
				notifyAll();
				//如果集合list不为空，则等待
				//当前线程（消费线程）
				//一旦进入等待状态，那么将会释放锁对象
				wait();
			}
		}
	}
	
	
}