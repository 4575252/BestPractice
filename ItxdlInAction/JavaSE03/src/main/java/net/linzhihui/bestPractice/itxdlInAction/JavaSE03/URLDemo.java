package net.linzhihui.bestPractice.itxdlInAction.JavaSE03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	public static void main(String[] args) throws IOException {
		//根据网址构造URL对象
		URL url = new URL(
				"http://e.hiphotos.baidu.com/album/w%3D2048/sign=9b7795ff0b55b3199cf9857577918026/4d086e061d950a7b36bc973a0bd162d9f3d3c947.jpg");
		
		System.out.println("主机名："+url.getHost());
		System.out.println("资源路径："+url.getPath());
		System.out.println("端口号："+url.getPort());
		System.out.println("协议:"+url.getProtocol());
		
		//通过URL打开连接
		URLConnection conn = url.openConnection();
		//截取文件名 
		String filename = url.getPath().substring(url.getPath().lastIndexOf("/"));
		//获取连接的输入流对象
		BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
		//构造文件输出流对象
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\"+filename));
		
		byte[] bytes = new byte[1024*10];
		int len = -1;
		while((len=bis.read(bytes))!=-1){
			bos.write(bytes, 0, len);
			bos.flush();
		}
		bos.close();
		bis.close();
		System.out.println("下载完成。");
	}

}



















