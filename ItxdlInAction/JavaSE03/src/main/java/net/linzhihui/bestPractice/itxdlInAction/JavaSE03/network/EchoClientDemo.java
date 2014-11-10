package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.network;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * echo客户端程序
 * @author lamp
 *
 */
public class EchoClientDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("127.0.0.1",8000);
		System.out.println("与服务器连接成功！");
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		//获取输入输出流
		PrintStream ps = new PrintStream(
				new BufferedOutputStream(s.getOutputStream()));
		BufferedReader br = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		while(flag){
			System.out.println("请输入：");
			String info = input.next();
			if("bye".equals(info)){
				flag = false;
			}else{
				ps.println(info);
				ps.flush();
				System.out.println(br.readLine());
			}
		}
		br.close();
		ps.close();
	}
}














