package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * UDP发送端
 * @author lamp
 *
 */
public class UDPServerDemo {

	public static void main(String[] args) throws IOException {
		String info = "小新有一只狗，小时候叫小白，大了叫大白，老了叫老白，死了就是白白!";
		//把数据转换成字节数组
		byte[] bytes = info.getBytes();
		//创建一个数据报包对象,参数(要发送的字节数组，数组起始位置，要发送数组的长度，InetAddress，接收端端口号)
		DatagramPacket data = new DatagramPacket(
				bytes,0,bytes.length,
				InetAddress.getByName("127.0.0.1"),5000);
		//创建一个UDP协议的 Socket对象
		DatagramSocket ds = new DatagramSocket(3000);
		ds.send(data);//发送数据报
		System.out.println("发送完毕");
		
		
	}

}










