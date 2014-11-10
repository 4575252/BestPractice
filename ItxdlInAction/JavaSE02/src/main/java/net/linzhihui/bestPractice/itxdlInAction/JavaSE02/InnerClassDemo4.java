package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;

/**
	内部类：匿名内部类
*/
public class InnerClassDemo4{
	public static void main(String[] args){
		//(1)继承式匿名内部类
		Dog4 dog = new Dog4("花花"){
			public void say(){
				System.out.println("我是一只母狗，主人叫我"+name);
			}
		};
		dog.say();

		//(2)接口式匿名内部类
		Child4 child = new Child4(){
			public void talk(){
				System.out.println("我是一只狗狗");
			}
		};
		child.talk();

		//(3)参数式匿名内部类
		childTalk(new Child4(){
			public void talk(){
				System.out.println("我是一只小狗狗");
			}
		});

	}

	public static void childTalk(Child4 c){
		c.talk();
	}

}

//狗类
class Dog4{
	String name;
	public Dog4(String name){
		this.name = name;
	}
	public void say(){
		System.out.println("我是一只狗，主人叫我"+name);
	}
}

class WomenDog4 extends Dog4{
	public WomenDog4(String name){
		super(name);
	}
	public void say(){
		System.out.println("我是一只母狗，主人叫我"+name);
	}
}

interface Child4{
	public void talk();
}

