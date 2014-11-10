package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.decorator;

/**
 * 具体的装饰者对象：鸡蛋
 * @author lamp
 *
 */
public class EggDecorator extends Decorator{

	public EggDecorator(Drink drink) {
		super(drink);
	}
	
	@Override
	public String description() {
		return super.description()+"+鸡蛋";
	}
	
	@Override
	public float cost() {
		return super.cost()+2.0f;
	}
	
}
