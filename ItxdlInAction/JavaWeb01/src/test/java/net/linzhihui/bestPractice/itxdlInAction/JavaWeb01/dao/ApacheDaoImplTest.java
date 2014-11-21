package net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.tools.JdbcTemplate;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ApacheDaoImplTest {

	private static PersonDao dao;

	@Before
	public void setUp() throws Exception {
		dao = new ApacheDaoImpl();
		
		JdbcTemplate jdbcTemplate;
		jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.initDbConnection(null);
		jdbcTemplate.update("DROP TABLE IF EXISTS `person`");
		jdbcTemplate.update("CREATE TABLE `person` (" + "		  `id` int NOT NULL,"
				+ "		  `name` varchar(50) DEFAULT NULL,"
				+ "		  `age` int(11) DEFAULT NULL,"
				+ "		  `description` varchar(500) DEFAULT NULL,"
				+ "		  PRIMARY KEY (`id`)"
				+ "		)");
	}

	@After
	public void tearDown() throws Exception {
		JdbcTemplate jdbcTemplate;
		jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.initDbConnection(null);
		jdbcTemplate.update("DROP TABLE IF EXISTS `person`");
	}

	@Test
	@Ignore
	public void testApacheDaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		Person p = new Person();
		p.setId(100);
		p.setName("张三");
		p.setAge(23);
		p.setDescription("description");
		try {
			dao.add(p);
			Person t = dao.findById(p.getId());
			assertEquals("张三", t.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Person p = new Person();
		p.setId(101);
		p.setName("李四");
		p.setAge(23);
		p.setDescription("description");
		try {
			dao.add(p);
			Person t = dao.findById(p.getId());
			assertEquals("李四", t.getName());
			
			p.setName("王五");
			dao.update(p);
			t = dao.findById(p.getId());
			assertEquals("王五", t.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Person p = new Person();
		p.setId(102);
		p.setName("赵六");
		p.setAge(23);
		p.setDescription("description");
		try {
			dao.add(p);
			Person t = dao.findById(p.getId());
			assertEquals("赵六", t.getName());
			
			dao.delete(p.getId());;
			assertNull(dao.findById(p.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindById() {
		Person p = new Person();
		p.setId(103);
		p.setName("钱七");
		p.setAge(23);
		p.setDescription("description");
		try {
			dao.add(p);
			Person t = dao.findById(p.getId());
			assertEquals("钱七", t.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindAll() {
		Person p = new Person();
		p.setId(104);
		p.setName("钱104");
		p.setAge(23);
		p.setDescription("description");
		try {
			dao.add(p);
			Person t = dao.findById(p.getId());
			assertEquals("钱104", t.getName());
			
			List<Person> list = dao.findAll();
			assertTrue(list.size()>0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPersonCount() {
		Person p = new Person();
		p.setId(105);
		p.setName("钱105");
		p.setAge(23);
		p.setDescription("description");
		try {
			dao.add(p);
			Person t = dao.findById(p.getId());
			assertEquals("钱105", t.getName());

			long l = dao.personCount();
			assertTrue(l>0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
