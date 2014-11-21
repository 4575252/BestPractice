/**
 * 
 */
package net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.tools.DBUtils;
import net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.tools.JdbcTemplate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author linzh11
 *
 */
public class JdbcTemplateDaoImplTest {

	private static PersonDao dao;
	
	private static JdbcTemplate jdbcTemplate;
	
	private static Connection conn;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = DBUtils.getConnection();
		jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.initDbConnection(conn);
		dao = new JdbcTemplateDaoImpl(jdbcTemplate);
		

		jdbcTemplate.update("DROP TABLE IF EXISTS `person`");
		jdbcTemplate.update("CREATE TABLE `person` (" + "		  `id` int NOT NULL,"
				+ "		  `name` varchar(50) DEFAULT NULL,"
				+ "		  `age` int(11) DEFAULT NULL,"
				+ "		  `description` varchar(500) DEFAULT NULL,"
				+ "		  PRIMARY KEY (`id`)"
				+ "		)");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		jdbcTemplate.update("DROP TABLE IF EXISTS `person`");
		DBUtils.close(null, null, conn);
	}

	/**
	 * Test method for {@link net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.JdbcTemplateDaoImpl#JdbcTemplateDaoImpl()}.
	 */
	@Test
	@Ignore
	public void testJdbcTemplateDaoImpl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.JdbcTemplateDaoImpl#add(net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.Person)}.
	 */
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

	/**
	 * Test method for {@link net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.JdbcTemplateDaoImpl#update(net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.Person)}.
	 */
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

	/**
	 * Test method for {@link net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.JdbcTemplateDaoImpl#delete(int)}.
	 */
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

	/**
	 * Test method for {@link net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.JdbcTemplateDaoImpl#findById(int)}.
	 */
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

	/**
	 * Test method for {@link net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.JdbcTemplateDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		try {
			List<Person> list = dao.findAll();
			assertTrue(list.size()>0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.dao.JdbcTemplateDaoImpl#personCount()}.
	 */
	@Test
	@Ignore
	public void testPersonCount() {
		fail("Not yet implemented");
	}

}
