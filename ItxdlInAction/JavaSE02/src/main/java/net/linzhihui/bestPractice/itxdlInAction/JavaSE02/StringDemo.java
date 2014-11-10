package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;
//import java.lang.String;
/**
	字符串类
	java.lang包是java的默认引入的包，所以我们不需显示的导包
*/
public class StringDemo{
	public static void main(String[] args){
		//创建字符串的方式一：
		//会创建两个字符串对象
		String s1 = new String("小白");
		//创建字符串的方式二：
		//最多创建一个字符串对象，有可能不用创建对象
		String s2 = "小白";

		System.out.println("s1="+s1);
		System.out.println("s2="+s2);

	}
}