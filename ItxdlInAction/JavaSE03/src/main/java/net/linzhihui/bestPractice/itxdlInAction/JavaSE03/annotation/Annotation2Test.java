package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.annotation;

import java.lang.annotation.Annotation;

public class Annotation2Test {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("net.linzhihui.bestPractice.itxdlInAction.JavaSE03.annotation.Annotation2");
			Annotation[] as = c.getAnnotations();
			for (Annotation annotation : as) {
				System.out.println(annotation);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
