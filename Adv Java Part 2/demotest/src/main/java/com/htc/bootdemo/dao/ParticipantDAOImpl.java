package com.htc.bootdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.bootdemo.model.Participant;


@Repository
public class ParticipantDAOImpl implements ParticipantDAO
{
	@Autowired //by type
	JdbcTemplate jdbcTemplate;

	public boolean addEmployee(Participant emp) {

		int result = jdbcTemplate.update("insert into employees values(?,?,?,?)", emp.getPno(), emp.getPname(), emp.getEmail(), emp.getCity());
		if(result > 0) 
			return true;
		return false;
	}


	public boolean addEmployee(int empno, String ename, String job, double salary) {
		return addEmployee(new Participant(empno,ename, job, salary));
	}


	public Participant getEmployee(int empno) {

		Participant emp = null;
		emp = jdbcTemplate.queryForObject("select empno, empname, job, salary from employees where empno = ?", 
				new Object[] {empno},
				new RowMapper<Participant>() {
			@Override
			public Participant mapRow(ResultSet rs, int arg1) throws SQLException {
				Participant e = new Participant();
				e.setPno(rs.getInt(1));
				e.setPname(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setCity(rs.getDouble(4));
				return e;
			}
		});
		return emp;
	}

	@Override
	public List<Participant> getEmployees() {

		List<Participant> empList = null;

		empList = jdbcTemplate.query("select empno, empname, job, salary from employees", 
				new RowMapper<Participant>() {

			@Override
			public Participant mapRow(ResultSet rs, int arg1) throws SQLException {
				Participant e = new Participant();
				e.setPno(rs.getInt(1));
				e.setPname(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setCity(rs.getDouble(4));
				return e;

			}

		});
		return empList;
	}

	public boolean deleteEmployee(int empno) {

		NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate);

		Map<String, Integer> params = new HashMap<>();
		params.put("eno", empno);

		int result = npjt.update("delete from employees where empno=:eno", params);
		if(result>0) 
			return true;
		return false;
	}

	public boolean updateEmployee(Participant newemp) 
	{
		int result = jdbcTemplate.update("update employees set empname =? , job =? ,salary = ?  where empno= ?",newemp.getPname(),newemp.getEmail(),newemp.getCity(),newemp.getPno());
		if(result>0) 
			return true;
		else
			return false;
	}
}
