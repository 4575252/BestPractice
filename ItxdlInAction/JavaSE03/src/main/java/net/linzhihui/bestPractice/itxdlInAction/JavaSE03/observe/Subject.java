package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.observe;

/**
 * 被观察者接口
 * @author lamp
 *
 */
public interface Subject {
	/**
	 * 注册为一个观察者
	 * @param o
	 */
	public void registerObserver(Observer o);
	/**
	 * 取消观察者
	 * @param o
	 */
	public void removeObserver(Observer o);
	/**
	 * 通知所有观察者更新信息
	 */
	public void notifyObservers();
}
