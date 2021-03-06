package net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
	//添加方法
	public void add(Person p)throws SQLException;
	
	//更新方法
	public void update(Person p)throws SQLException;
	
	//删除方法
	public void delete(int id)throws SQLException;
	
	//查找方法
	public Person findById(int id)throws SQLException;
	
	//查找所有
	public List<Person> findAll()throws SQLException;
	
	//查询所有记录
	public long personCount()throws SQLException;
	
}



















