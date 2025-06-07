package com.ty.bikemanagement.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.ty.bikemanagement")
@EnableTransactionManagement
public class AppConfig {
	
	@Bean
	public DataSource getDataSource() {
		//BasicDataSource:- by using it we can set the dataconfiguration
		//it is provided by database connection pool
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("org.postgresql.Driver");
		datasource.setUrl("jdbc:postgresql://localhost:5432/spring");
		datasource.setUsername("postgres");
		datasource.setPassword("root");

		return datasource;
	}
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	    HibernateTransactionManager txManager = new HibernateTransactionManager();
	    txManager.setSessionFactory(sessionFactory);
	    return txManager;
	}


	@Bean
	public LocalSessionFactoryBean getLocalSessionFactory() {
		// used to keep the hibernate properties
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setPackagesToScan("com.ty.bikemanagement.model");
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		
		factory.setHibernateProperties(properties);
		return factory;
	}

	@Bean
	public HibernateTemplate geHibernateTemplate(SessionFactory s) {
		return new HibernateTemplate(s);
	}
}
