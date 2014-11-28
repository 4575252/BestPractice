package org.chapter0326;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class IntroduceAdvisorTest {
    private String configPath ="";
    private ApplicationContext ctx =null;

	@Before
	public void setUp() throws Exception {
        configPath = "conf/beans26.xml";
        ctx = new ClassPathXmlApplicationContext(configPath);
	}

	@Test
	public void test() {
        ViewSpaceService viewSpaceService = (ViewSpaceService)ctx.getBean("viewSpaceService");
        viewSpaceService.deleteViewSpace(10);
        Monitorable moniterable = (Monitorable)viewSpaceService;
        moniterable.setMonitorActive(true);
        viewSpaceService.deleteViewSpace(10);
        viewSpaceService.deleteViewPoint(10);
	}

}
