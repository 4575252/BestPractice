package net.linzhihui.bestPractice.itxdlInAction.JavaSE03;

import java.util.Date;

/**
 * 多线程的实现方式：
 * 1、继承Thread类
 * 2、实现Runnable接口
 * @author lamp
 *
 */
public class ThreadDemo {

	public static void main(String[] args) {
		//使用自定义线程
		MyThread myThread = new MyThread();
		myThread.start();//启动线程
		for (int i = 0; i < 20; i++) {
			System.out.println("main-"+i);
		}
		
		//
		MyRunnable myRunnable = new MyRunnable();
		//myRunnable.run();
		Thread thread2 = new Thread(myRunnable);
		thread2.start();
		
	}

}

// 自定义线程类1
class MyThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(new Date()+"-"+i);
		}
	}
}

//自定义的线程2
class MyRunnable implements Runnable{

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("MyRunnale-"+i);
		}
	}
	
}













