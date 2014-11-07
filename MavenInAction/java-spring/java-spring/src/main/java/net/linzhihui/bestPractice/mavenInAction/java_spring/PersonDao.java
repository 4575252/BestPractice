package net.linzhihui.bestPractice.mavenInAction.java_spring;


public class PersonDao implements IPersonDao {

	public void save() {
		System.out.println("------------from PersonDao.save()");
	}

}
