package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.network;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * echo服务器端程序
 * 
 * @author lamp
 * 
 */
public class EchoServerDemo {

	public static void main(String[] args) throws IOException {
		// 创建一个服务器端的Socket
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("服务器已启动");
		boolean flag = true;
		while (flag) {
			System.out.println("正在等待连接。。。");
			Socket s = ss.accept();
			new Thread(new UserThread(s)).start();

		}
	}

}

/**
 * 处理用户请求的线程
 * 
 * @author lamp
 * 
 */
class UserThread implements Runnable {
	private Socket s;

	public UserThread(Socket s) {
		this.s = s;
	}

	public void run() {
		System.out.println(s.getInetAddress().getHostAddress() + "已连接");
		try {
			// 获取输入输出流
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			PrintStream ps = new PrintStream(new BufferedOutputStream(
					s.getOutputStream()));
			boolean bool = true;// 循环接收数据
			while (bool) {
				String info = br.readLine();
				if ("".equals(info) || "bye".equals(info)) {
					bool = false;
				} else {
					System.out.println(info);
					ps.println("echo:" + info);
					ps.flush();
				}
			}
			ps.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}






