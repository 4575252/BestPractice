package net.linzhihui.bestPractice.itxdlInAction.JavaSE03;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * url 地址编码与解码
 * @author lamp
 *
 */
public class URLDemo2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = "http://www.weige.com/username=小白&password=123";
		//把URL地址进行编码
		url = URLEncoder.encode(url, "UTF-8");
		System.out.println(url);
		//把URL地址进行解码
		url = URLDecoder.decode(url, "UTF-8");
		System.out.println(url);
	}

}
