package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务器端程序
 * @author lamp
 *
 */
public class ServerDemo {

	public static void main(String[] args) {
		//创建一个服务器端的Socket
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("服务器已启动，正在等待连接中...");
			Socket s = server.accept();//等待客户端连接,会阻塞
			String info = "亲，您的宝贝已发出，请注意查收！\n";
			//构造一个字符输出流
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(s.getOutputStream()));
			bw.write(info);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}



















