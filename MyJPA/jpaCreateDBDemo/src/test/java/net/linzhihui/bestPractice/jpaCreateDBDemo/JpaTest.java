package net.linzhihui.bestPractice.jpaCreateDBDemo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class JpaTest {

	@Test
	public void testCreate() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		System.out.println("Db create done");

	}
}