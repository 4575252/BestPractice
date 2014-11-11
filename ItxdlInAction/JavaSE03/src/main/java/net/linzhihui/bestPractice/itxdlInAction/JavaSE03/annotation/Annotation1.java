package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.annotation;

public class Annotation1 {
	
	@SuppressWarnings("unused")
	private String id;
	
	private String name;
	@Deprecated
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return super.toString()+" hello!";
	}
}
