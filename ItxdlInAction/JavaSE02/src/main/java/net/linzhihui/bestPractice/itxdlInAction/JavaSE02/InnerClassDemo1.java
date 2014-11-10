package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;

/**
	内部类：成员内部类
*/
public class InnerClassDemo1{
	public static void main(String[] args){
		Dog d = new Dog("花花");
		d.say();
		Dog.ChildDog child = null;//声明内部类引用

		//该方式一般不使用
		child = d.new ChildDog();//创建内部类的实例
		child.talk();

		d.childTalk();

	}
}

//狗类
class Dog{
	private String name;
	public Dog(String name){
		this.name = name;
	}
	public void say(){
		System.out.println("我是一只狗，主人叫我"+name);
	}
	//内部类(成员内部类)
	class ChildDog{
		public void talk(){
			System.out.println("我是一只狗狗，我妈是"+name);
		}
	}
	
	public void childTalk(){
		ChildDog child = new ChildDog();
		child.talk();
	}
}