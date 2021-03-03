package com.htc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.htc.spring.dao.EmployeeDAOImpl;

@ComponentScan("com.htc.spring")
@Configuration
public class BeansConfig {

	@Bean(name="dataSource")
	public  DriverManagerDataSource getdataSource(){

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("root");

		return dataSource;

	}

	@Bean(name="jdbcTemplate")	
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getdataSource());

		return jdbcTemplate;
	}

	@Bean(name="employeeDAO")
	public EmployeeDAOImpl  getemployeeDAO(){

		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();		
		//employeeDAO.setJdbcTemplate(jdbcTemplate());

		return employeeDAO;		

	}
}
