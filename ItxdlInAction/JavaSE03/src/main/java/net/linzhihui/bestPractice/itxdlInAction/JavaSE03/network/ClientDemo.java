package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP客户端程序
 * @author lamp
 *
 */
public class ClientDemo {

	public static void main(String[] args) {
		
		try {
			//创建 一个客户端的socket对象(IP/主机名，端口号)
			Socket s = new Socket("127.0.0.1",8888);
			System.out.println("与服务器连接成功！");
			//构造一个字符输入流
			BufferedReader br = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			String info = br.readLine();
			System.out.println(info);
			br.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
