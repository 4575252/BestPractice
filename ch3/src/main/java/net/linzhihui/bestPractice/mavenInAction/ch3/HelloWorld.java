package net.linzhihui.bestPractice.mavenInAction.ch3;

public class HelloWorld {

	public String sayHello()
	{
		return "Hello Maven";
	}
	
	public static void main(String[] args)
	{
		System.out.print( new HelloWorld().sayHello() );
	}
}
