package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;

/**
	内部类：方法内部类
*/
public class InnerClassDemo2{
	public static void main(String[] args){
		Dog2 d = new Dog2("花花");
		d.childTalk("小小花");

	}
}

//狗类
class Dog2{
	private String name;
	public Dog2(String name){
		this.name = name;
	}
	public void say(){
		System.out.println("我是一只狗，主人叫我"+name);
	}
	public Child child;
	//在方法里面声明一个内部类
	public void childTalk(final String childName){
		final int x = 10;
		class ChildDog2 implements Child{
			public void talk(){
				System.out.println("我是一只狗狗，我妈妈是"+name);
				System.out.println("x="+x);
				System.out.println("我的名字是"+childName);
			}
		}
		child = new ChildDog2();
		child.talk();
	}

	
}
interface Child{
	public void talk();
}

