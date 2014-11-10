package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.decorator;

/**
 * 具体的被装饰者对象：纯豆浆
 * @author lamp
 *
 */
public class SoyaBeanMilk implements Drink{

	public String description() {
		return "纯豆浆";
	}

	public float cost() {
		return 5f;
	}

}
