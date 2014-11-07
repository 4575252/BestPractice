package net.linzhihui.bestPractice.mavenInAction.java_mybatis;

import java.util.List;

public interface IPersonEntityDao {
	/**
	 * 插入一条记录
	 * @param person
	 */
	public void insert(PersonEntity person);
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<PersonEntity> queryAll();
}
