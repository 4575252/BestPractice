package org.chapter0314;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ViewSpaceServiceTest {

	@Test
	public void test() {
        String configPath = "conf/beans14.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ViewSpaceService viewSpaceService = (ViewSpaceService) ctx.getBean("viewSpaceService");

//        try {
//            boolean result = viewSpaceService.deleteViewSpace("bbb");
//            System.out.println(".........." + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            viewSpaceService.updateViewSpace("aaa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
