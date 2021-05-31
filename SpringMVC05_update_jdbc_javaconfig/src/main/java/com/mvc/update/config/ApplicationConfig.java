package com.mvc.update.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// applicationContext.xml을 .java로 변환

@Configuration
@PropertySource("classpath:sqls/db.properties") // <context:property-placeholder location="classpath:sqls/db.properties" />
public class ApplicationConfig {
	
	@Value("${oracle.driver}")
	private String driver;
	
	@Value("${oracle.url}")
	private String url;
	
	@Value("${oracle.username}")
	private String username;
	
	@Value("${oracle.password}")
	private String password;
	
	// bean 객체를 대신함
	/*
	 * <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		 <property name="driverClassName" value="${oracle.driver}" />
		 <property name="url" value="${oracle.url}" />
		 <property name="username" value="${oracle.username}" />
		 <property name="password" value="${oracle.password}" />
	   </bean>
	 */
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		
		return dataSource;
	}
	
	/*
	 * <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		 <property name="dataSource" ref="dataSource" />
	   </bean> 
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		
		return jdbcTemplate;
	}
}
