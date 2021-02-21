package com.htc.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.htc.spring.beans.Employee;

public class EmployeeDAOImpl implements EmployeeDAO 
{
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addEmployee(Employee emp) {

		int result = jdbcTemplate.update("insert into employees values(?,?,?,?)", emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getSalary());
		if(result > 0) 
			return true;

		return false;
	}

	@Override
	public boolean addEmployee(int empno, String ename, String job, double salary) {
		return addEmployee(new Employee(empno,ename, job, salary));
	}

	@Override
	public Employee getEmployee(int empno) {

		Employee emp = null;
		emp = jdbcTemplate.queryForObject("select empno, empname, job, salary from employees where empno = ?", 
				new Object[] {empno},
				new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee e = new Employee();
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setSalary(rs.getDouble(4));
				return e;
			}

		});
		return emp;
	}

	@Override
	public List<Employee> getEmployees() {

		List<Employee> empList = null;

		empList = jdbcTemplate.query("select empno, empname, job, salary from employees", 
				new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee e = new Employee();
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setSalary(rs.getDouble(4));
				return e;

			}

		});
		return empList;
	}

	@Override
	public boolean deleteEmployee(int empno) {

		NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate);

		Map<String, Integer> params = new HashMap<>();
		params.put("eno", empno);

		int result = npjt.update("delete from employees where empno=:eno", params);
		if(result>0) 
			return true;
		return false;
	}

	@Override
	public boolean updateEmployee(int empno,double sal) 
	{
		SimpleJdbcCall jdbccall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("updateEmployee"); 
		
		SqlParameterSource ps = new MapSqlParameterSource().addValue("eno", empno).addValue("sal", sal);
		
		boolean result = jdbccall.executeFunction(boolean.class, ps);
		return result;
	}
}
