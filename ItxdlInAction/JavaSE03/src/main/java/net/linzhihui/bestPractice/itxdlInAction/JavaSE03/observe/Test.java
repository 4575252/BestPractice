package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.observe;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建一个被观察者对象
		Doll doll  = new Doll(3000);
		Person p1 = new Person("小白");
		Person p2 = new Person("小黑");
		doll.registerObserver(p1);//注册成为一个观察者
		doll.registerObserver(p2);
		System.out.println("第一轮促销：");
		doll.setPrice(2698);// 价格变动
		System.out.println("第二轮促销：");
		doll.setPrice(2299);//
		System.out.println("第三轮促销：");
		doll.setPrice(1998);
		doll.removeObserver(p2);
		System.out.println("第四轮促销：");
		doll.setPrice(1098);
		
		
	}

}
