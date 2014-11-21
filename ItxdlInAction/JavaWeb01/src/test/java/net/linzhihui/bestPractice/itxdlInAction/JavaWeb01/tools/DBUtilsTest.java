package net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.tools;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBUtilsTest {

	private static Connection conn;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DBUtils.close(null, null, conn);
	}

	@Test
	public void testGetConnection() {
		conn = DBUtils.getConnection();
		assertNotNull(conn);
	}

	@Test
	public void testClose() {
		Connection conn = DBUtils.getConnection();
		DBUtils.close(null, null, conn);
		assertTrue(true);
	}

}
