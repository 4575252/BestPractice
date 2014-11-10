package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.observe;
/**
 * 具体的观察者对象
 * @author lamp
 *
 */
public class Person implements Observer{
	private String name;
	public Person(String name){
		this.name = name;
	}

	public void update(float price) {
		System.out.println(name+"关注的娃娃的价格已更新为："+price);
	}

}
