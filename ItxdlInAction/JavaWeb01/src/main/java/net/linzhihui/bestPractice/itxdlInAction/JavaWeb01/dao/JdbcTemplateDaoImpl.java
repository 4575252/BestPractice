package net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.tools.JdbcTemplate;
import net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.tools.ResultSetHandler;
/**
 * PersonDao的具体实现类
 * @author lamp
 *
 */
public class JdbcTemplateDaoImpl implements PersonDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplateDaoImpl(){
		jdbcTemplate = new JdbcTemplate();
	}
	
	public JdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 实现添加方法
	 */
	public void add(Person p) throws SQLException {
		String sql = "insert into person(id,name,age,description)values(?,?,?,?)";
		jdbcTemplate.update(sql, p.getId(), p.getName(),p.getAge(),p.getDescription());
	}

	/**
	 * 更新方法
	 */
	public void update(Person p) throws SQLException {
		String sql = "update person set name=?,age=?,description=? where id=?";
		jdbcTemplate.update(sql, p.getName(),p.getAge(),p.getDescription(),p.getId());
	}

	/**
	 * 删除方法
	 */
	public void delete(int id) throws SQLException {
		String sql = "delete from person where id=?";
		jdbcTemplate.update(sql, id);
	}

	/**
	 * 根据ID查询一个对象
	 */
	public Person findById(final int id) throws SQLException {
		String sql = "select name,age,description from person where id=?";
		return (Person)jdbcTemplate.query(sql, new ResultSetHandler() {
			public Object doHandler(ResultSet rs)throws SQLException {
				Person p = null;
					if(rs.next()){
						p = new Person();
						p.setId(id);
						p.setName(rs.getString(1));
						p.setAge(rs.getInt(2));
						p.setDescription(rs.getString(3));
					}
				return p;
			}
		}, id);
	}

	/**
	 * 查询所有数据
	 */
	@SuppressWarnings("unchecked")
	public List<Person> findAll() throws SQLException {
		String sql = "select id,name,age,description from person";
		return ((List<Person>)jdbcTemplate.query(sql, new ResultSetHandler() {
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Person> persons = new ArrayList<Person>();
				Person p = null;
				while(rs.next()){
					p = new Person();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setAge(rs.getInt(3));
					p.setDescription(rs.getString(4));
					persons.add(p);
				}
				return persons;
			}
		}));
	}


	public long personCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}















