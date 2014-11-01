package net.linzhihui.bestPractice.SpringJpaDemo;

/**
 * 
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * @author linzh
 * 
 */
public class JpaGenerate {

	private String properties = "jdbc.properties";
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private String packagesToScan;
	private String show_sql;
	private String format_sql;
	private String hbm2ddl;
	private String naming_strategy;

	public void setProperties(String properties) {
		this.properties = properties;
	}

	private void envInit() {
		Properties prop = new Properties();
		InputStream fis = null;
		try {
			// fis = ClassLoader.getSystemResourceAsStream(properties);
			fis = JpaGenerate.class.getClassLoader().getResourceAsStream(
					properties);

			prop.load(fis);
			this.driverClassName = prop.getProperty("jdbc.driverClassName");
			this.url = prop.getProperty("jdbc.url");
			this.username = prop.getProperty("jdbc.username");
			this.password = prop.getProperty("jdbc.password");

			this.packagesToScan = prop.getProperty("generate.packagesToScan");
			this.show_sql = prop.getProperty("generate.show_sql");
			this.format_sql = prop.getProperty("generate.format_sql");
			this.hbm2ddl = prop.getProperty("generate.hbm2ddl");
			this.naming_strategy = prop.getProperty("generate.naming_strategy");
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void generate() {
		// 初始化环境变量
		envInit();

		// 初始化数据源
		DataSource dataSource = initDataSource();

		// 填充实体管理工程
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);
		factory.setDataSource(dataSource);
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(packagesToScan);

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.ejb.naming_strategy",
				naming_strategy);
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
		jpaProperties.setProperty("hibernate.show_sql", show_sql);
		jpaProperties.setProperty("hibernate.format_sql", format_sql);
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
	}

	private DataSource initDataSource() {
		org.springframework.jdbc.datasource.DriverManagerDataSource dataSource;
		dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}
