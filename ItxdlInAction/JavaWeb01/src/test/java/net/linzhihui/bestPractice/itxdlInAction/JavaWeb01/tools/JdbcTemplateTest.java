package net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.Person;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JdbcTemplateTest {

	private Connection conn;

	private JdbcTemplate t;

	@Before
	public void setUp() throws Exception {
		t = new JdbcTemplate();
		conn = t.initDbConnection(null);
		t.update("DROP TABLE IF EXISTS `person`");
		t.update("CREATE TABLE `person` (" + "		  `id` int NOT NULL,"
				+ "		  `name` varchar(50) DEFAULT NULL,"
				+ "		  `age` int(11) DEFAULT NULL,"
				+ "		  `description` varchar(500) DEFAULT NULL,"
				+ "		  PRIMARY KEY (`id`)"
				+ "		)");
	}

	@After
	public void tearDown() throws Exception {
		t.update("DROP TABLE IF EXISTS `person`");
		DBUtils.close(null, null, conn);
	}

	@Test
	public void testInitDbConnection() {
		assertNotNull(t.initDbConnection(null));
	}

	@Test
	public void testUpdate() {
		int i = t.update("insert into person(id,name,age,description) values(?,?,?,?)", 101,
				"张三", 25, "中国人");
		assertEquals(i, 1);
		
		Person p = (Person) t.query("select id,name,age,description from person where id=?", new ResultSetHandler() {
			public Object doHandler(ResultSet rs) throws SQLException {
				Person p = null;
				if (rs.next()) {
					p = new Person();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setAge(rs.getInt(3));
					p.setDescription(rs.getString(4));
				}
				return p;
			}
		}, 101);
		assertNotNull(p);
		assertEquals(p.getName(),"张三");
		

		t.update("update person set name = ? where id = ?", "李四" ,101);
		p = (Person) t.query("select id,name,age,description from person where id=?", new ResultSetHandler() {
			public Object doHandler(ResultSet rs) throws SQLException {
				Person p = null;
				if (rs.next()) {
					p = new Person();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setAge(rs.getInt(3));
					p.setDescription(rs.getString(4));
				}
				return p;
			}
		}, 101);
		assertEquals(p.getName(),"李四");
		

		t.update("delete from person where id = ?", 101);
		p = (Person) t.query("select id,name,age,description from person where id=?", new ResultSetHandler() {
			public Object doHandler(ResultSet rs) throws SQLException {
				Person p = null;
				if (rs.next()) {
					p = new Person();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setAge(rs.getInt(3));
					p.setDescription(rs.getString(4));
				}
				return p;
			}
		}, 101);
		assertNull(p);
	}

	@Test
	public void testQuery() {
		assertEquals(t.update(
				"insert into person(id,name,age,description) values(?,?,?,?)",
				1, "张三", 25, "中国人"), 1);
		assertEquals(t.update(
				"insert into person(id,name,age,description) values(?,?,?,?)",
				2, "李四", 25, "中国人"), 1);

		int p = (Integer) t.query(
				"select count(1) cc from person where id in(?,?)",
				new ResultSetHandler() {
					public Object doHandler(ResultSet rs) throws SQLException {
						if (rs.next()) {
							return rs.getInt("cc");
						}
						return 0;
					}
				}, 1, 2);
		assertEquals(p, 2);
	}
}
