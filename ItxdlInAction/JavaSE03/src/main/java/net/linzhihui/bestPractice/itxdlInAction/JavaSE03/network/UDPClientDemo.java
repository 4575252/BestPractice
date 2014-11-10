package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP接收端
 * @author lamp
 *
 */
public class UDPClientDemo {

	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[1024];
		//创建一个数据报对象
		DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
		//创建UDP协议的Socket对象
		DatagramSocket ds = new DatagramSocket(5000);//在此端口进行监听
		System.out.println("接收端正在等待接收数据...");
		ds.receive(dp);//接收数据，该方法会造成阻塞
		String info = new String(dp.getData(),0,dp.getLength());
		System.out.println(info);
		ds.close();
	}

}
