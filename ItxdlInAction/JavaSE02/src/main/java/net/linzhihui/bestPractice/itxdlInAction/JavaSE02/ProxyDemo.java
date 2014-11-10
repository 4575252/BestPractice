package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;
/**
	代理模式（Proxy）：为其他对象提供一种代理以控制对这个对象的访问。
*/
public class ProxyDemo{
	public static void main(String[] args){
		Person2 p = new Person2("小白");
		//创建代理对象
		Matchmaker m = new Matchmaker(p);

		m.miai();//相亲

	}
}

/**
	主题接口
*/
interface Subject{
	public void miai();
}

/**
	被代理类
*/
class Person2 implements Subject{
	private String name;
	public Person2(String name){
		this.name = name;
	}
	public void miai(){
		System.out.println(name+"正在相亲中...");
	}
}

/**
	代理类
*/
class Matchmaker implements Subject{
	private Subject target;//要代理的目标对象

	public Matchmaker(Subject target){
		this.target = target;
	}
	//相亲之前要做的事情
	private void before(){
		System.out.println("为代理人匹配如意郎君");
	}
	//相亲之后要做的事情
	private void after(){
		System.out.println("本次相亲结束.");
	}

	//相亲方法
	public void miai(){
		before();
		//真正执行相亲方法
		target.miai();
		after();
	}
}