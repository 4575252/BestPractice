package net.linzhihui.bestPractice.mavenInAction.java_mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class PersonEntityDao implements IPersonEntityDao {
	public static final String NAMESPACE = "net.linzhihui.bestPractice.mavenInAction.java_mybatis.PersonEntityMapper";
	
	public void insert(PersonEntity person) {
		SqlSession session = MyBatisUtil.getSession();
		session.insert(NAMESPACE + ".insert" , person);
		
		session.commit();
		session.close();
	}

	public List<PersonEntity> queryAll() {
		SqlSession session = MyBatisUtil.getSession();
		List<PersonEntity> personList = session.selectList(NAMESPACE + ".queryAll");
		
		
		session.commit();
		session.close();
		
		return personList;
	}

}
