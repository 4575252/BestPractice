package net.linzhihui.bestPractice.mavenInAction.java_spring;


public class PersonService implements IPersonService {
	private IPersonDao personDao;
	
	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}

	public void processSave() {
		System.out.println("-------------from PersonService.processSave()");
		
		personDao.save();
	}

}
