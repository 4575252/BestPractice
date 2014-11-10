package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;
/**
	可变参数 JDK1.5新特性
	1.一个方法中只能出现一个可变参数
	2.多个参数时，可变参数必须是最后一个
*/
public class VarParamDemo{
	public static void main(String[] args){
		String[] names = {"梦梦","纯纯","萌萌","爱爱","凤凤"};
		//调用方法
//		method1(names);

		method2("梦梦","纯纯","萌萌","爱爱","凤凤");

	}

	//参数为可变参数
	public static void method2(String... names){
		for(String name:names){
			System.out.print(name+" ");
		}
	}

	public static void method1(String[] names){
		for(String name:names){
			System.out.print(name+" ");
		}
	}
}