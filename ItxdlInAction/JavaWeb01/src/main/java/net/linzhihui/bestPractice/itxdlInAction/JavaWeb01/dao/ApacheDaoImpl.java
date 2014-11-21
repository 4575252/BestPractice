package net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao;

import java.sql.SQLException;
import java.util.List;

import net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.tools.DBUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class ApacheDaoImpl implements PersonDao {
	private QueryRunner runner = null;//查询运行器
	
	public ApacheDaoImpl(){
		runner = new QueryRunner();
	}
	
	public void add(Person p) throws SQLException {
		String sql = "insert into person(id,name,age,description)values(?,?,?,?)";
		runner.update(DBUtils.getConnection(), sql, p.getId(), p.getName(), p.getAge(),
				p.getDescription());

	}

	public void update(Person p) throws SQLException {
		String sql = "update person set name=?,age=?,description=? where id=?";
		runner.update(DBUtils.getConnection(), sql, p.getName(),p.getAge(),p.getDescription(),p.getId());
	}

	public void delete(int id) throws SQLException {
		String sql = "delete from person where id=?";
		runner.update(DBUtils.getConnection(), sql, id);
	}
	
	/**
	 * 使用BeanHandler 查询一个对象
	 */
	public Person findById(int id) throws SQLException {
		String sql = "select name,age,description from person where id=?";
		Person p = runner.query(DBUtils.getConnection(), sql, 
				new BeanHandler<Person>(Person.class),id);
		return p;
	}

	public List<Person> findAll() throws SQLException {
		String sql = "select name,age,description from person";
		List<Person> persons = runner.query(DBUtils.getConnection(), sql, new BeanListHandler<Person>(Person.class));
		return persons;
	}
	
	public long personCount()throws SQLException{
		String sql = "select count(id) from person";
		return runner.query(DBUtils.getConnection(),sql, new ScalarHandler<Long>());
	}

}


















