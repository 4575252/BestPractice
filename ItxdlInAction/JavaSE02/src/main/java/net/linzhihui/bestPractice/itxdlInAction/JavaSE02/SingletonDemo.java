package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;
/**
	单例设计模式
*/
public class SingletonDemo {		 
    	public static void main(String[]args){
    		Singleton1 s = Singleton1.getInstance();
			s.print();
			Singleton1 s1 = Singleton1.getInstance();
			System.out.println(s==s1);

			Singleton2 s2 = Singleton2.getInstance();
			s2.print();
			

    	} 
}

/**
	把该类设计成单例设计模式
	饿汉式
*/
class Singleton1{
	
	//定义一个本类对象并实例化
	private static Singleton1 s = new Singleton1();

	//构造方法私有化
	private Singleton1(){}

	public static Singleton1 getInstance(){
		return s;
	}

	public void print(){
		System.out.println("饿汉式－单例设计模式");
	}
}

/**
	把该类设计成单例设计模式
	懒汉式(多线程访问时会有安全问题)
*/
class Singleton2{
	
	//定义一个本类对象并实例化
	private static Singleton2 s = null;

	//构造方法私有化
	private Singleton2(){}

	public static Singleton2 getInstance(){
		if(s==null){
			s = new Singleton2();
		}
		return s;
	}

	public void print(){
		System.out.println("懒汉式－单例设计模式");
	}
}
