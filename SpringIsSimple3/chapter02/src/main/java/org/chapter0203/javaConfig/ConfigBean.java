package org.chapter0203.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Bean
    public Domain getDomain() {
        return new Domain();
    }

    @Bean
    public Dao getDao() {
    	Dao d = new Dao();
    	d.setD(getDomain());
        return d;
    }

    @Bean
    public Service service() {
    	Service s = new Service();
    	s.setD(getDao());
    	return s;
    }
}
