package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;

import java.util.Random;
/**
	抽象类的应用
*/
public class AbstractClassDemo{
	public static void main(String[] args){
		LingjiuPalace lp = new Shemale("小白");
		System.out.println("小白应聘灵鹫宫宫女一事正式开始。");
		lp.action();
	}
}


abstract class LingjiuPalace{
	
	//招聘活动
	public void action(){
		if(competition()){
			System.out.println("恭喜你，加入灵鹫宫，周一上班");
		}else{
			System.out.println("sorry,学艺不精，没宫干净吧");
		}
	}

	//比赛方法
	public abstract boolean competition();//抽象方法
}


class Shemale extends LingjiuPalace{
	private String name;
	public Shemale(String name){
		this.name = name;
	}
	//实现比赛方法
	public boolean competition(){
		System.out.println("我是"+name);
		System.out.println("比赛开始，成不成功，听天由命!");
		Random r = new Random();
		return r.nextBoolean();
	}
}