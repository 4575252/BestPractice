package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.thread;
/**
 * 生产者与消费者的应用案例
 * 1、sleep和wait的区别
 * 
 * 
 * @author lamp
 *
 */
public class ThreadDemo {

	public static void main(String[] args) {
		Food f = new Food();
		Producter p = new Producter(f);
		Consumer c = new Consumer(f);
		new Thread(p).start();
		new Thread(c).start();
		
	}

}

/**
 * 生产者：厨师
 * @author lamp
 *
 */
class Producter implements Runnable{
	private Food food;
	public Producter(Food food){
		this.food = food;
	}
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(i%2==0){
				food.set("韭菜炒鸡蛋", "男人的好食品，多吃有益身体健康");
			}else{
				food.set("葱爆腰花", "补肾气，通膀胱，我好她就好！");
			}
		}
	}
}

/**
 * 消费者：服务员
 * @author lamp
 *
 */
class Consumer implements Runnable{
	
	private Food food;
	public Consumer(Food food){
		this.food = food;
	}
	public void run() {
		for (int i = 0; i < 100; i++) {
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(food.getName()+":"+food.getContent());
			food.get();
		}
	}
}

/**
 * 产品：食物
 * @author lamp
 *
 */
class Food{
	private String name;
	private String content;
	
	private boolean flag = true;//true表示可以生产，false表示可以消费
	
	public String getName() {
		return name;
	}
	//生产产品
	public synchronized void set(String name,String content){
		if(!flag){
			try {
				this.wait();//让当前线程进入等待池等待，没有指定时间，
							//需要其它线程唤醒，释放对象锁,让出CPU
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.setName(name);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setContent(content);
		flag = false;//表示可以消费
		this.notify();//唤醒在该监视器上的一个线程
		
	}
	//消费产品
	public synchronized void get(){
		if(flag){
			try {
				this.wait();//让当前线程进入等待池等待，没有指定时间，
							//需要其它线程唤醒，释放对象锁,让出CPU
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName()+":"+this.getContent());
		flag = true;
		this.notify();
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Food(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}
	public Food() {
		super();
	}
	@Override
	public String toString() {
		return "Food [name=" + name + ", content=" + content + "]";
	}
	
}




























