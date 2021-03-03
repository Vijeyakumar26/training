package com.htc.spring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableAspectJAutoProxy   //Enable AOP 
@EnableTransactionManagement   // to Enable annotation based transaction management.
@PropertySource(value="classpath:connection.properties")
@ComponentScan(basePackages= {"com.htc.spring"})   // to scan for spring component in the application											// and register in the context automatically.
public class TxConfig {

	@Autowired
	Environment env;  //

	@Bean(name="dataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}
	
	@Bean(name="transactionManager")
	public DataSourceTransactionManager getTransactionManager() {
		DataSourceTransactionManager tr = new DataSourceTransactionManager();
		tr.setDataSource(getDataSource());
		return tr;
	}

}
