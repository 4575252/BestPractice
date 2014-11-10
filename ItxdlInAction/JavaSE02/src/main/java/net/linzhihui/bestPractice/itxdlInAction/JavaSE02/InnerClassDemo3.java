package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;

/**
	内部类：静态内部类
	一个静态内部类相当于外部类
*/
public class InnerClassDemo3{
	public static void main(String[] args){
		Dog3.ChildDog3 child = new Dog3.ChildDog3();
		child.talk();

		Dog3.childTalk();

	}
}

//狗类
class Dog3{
	private String name;
	public Dog3(String name){
		this.name = name;
	}
	public void say(){
		System.out.println("我是一只狗，主人叫我"+name);
	}

	//静态内部类
	static class ChildDog3{
		public void talk(){
			System.out.println("我是一只狗狗");
		}
	}
	
	public static void childTalk(){
		ChildDog3 c = new ChildDog3();
		c.talk();
	}
	
}

