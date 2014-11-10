package net.linzhihui.bestPractice.itxdlInAction.javase01;

import java.util.Scanner;

/**
 * Scanner Demo
 * 包括类型检查，输入错误则报错,错误类型很多，包括字符集不支持、类型转换错误、NPE等等，可根据需要单独捕获再行处理
 */
public class ScannerDemo {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		// receive string
		String str = s.next();

		// receive integer
		Integer i = s.nextInt();

		// receive double
		Double d = s.nextDouble();

		System.out.println(str + i + d);
	}
}