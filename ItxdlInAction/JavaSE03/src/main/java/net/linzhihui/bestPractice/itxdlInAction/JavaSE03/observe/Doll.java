package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.observe;

import java.util.Vector;

/**
 * 具体的被观察者对象：娃娃
 * @author lamp
 *
 */
public class Doll implements Subject{
	//被观察者维护的一个观察者对象列表
	private Vector<Observer> v = new Vector<Observer>();
	private float price;
	
	public Doll(float price){
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		//修改价格时，通知所有观察者
		this.price = price;
		notifyObservers();
	}


	public void registerObserver(Observer o) {
		//注册观察者
		v.add(o);
	}

	public void removeObserver(Observer o) {
		//取消观察者
		v.remove(o);
	}

	public void notifyObservers() {
		//实现通知所有的观察者对象
		for (Observer o:v) {
			o.update(price);
		}
	}

}




















