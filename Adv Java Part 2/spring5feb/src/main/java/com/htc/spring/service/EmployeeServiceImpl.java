package com.htc.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.htc.spring.beans.Employee;
import com.htc.spring.dao.EmployeeDAO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeDAO empdao;
	
	public EmployeeDAO getEmpdao() {
		return empdao;
	}
	public void setEmpdao(EmployeeDAO empdao) {
		this.empdao = empdao;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=java.lang.Exception.class)
	public boolean addEmployee(Employee emp) {
		try {
	
			return empdao.addEmployee(emp);
			//additioanl logic
		}
		catch(Exception ex) {
			return false;
		}
	}
	

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=java.lang.Exception.class)	
	public boolean addEmployee(int empno, String ename, String job, double salary) {
		return empdao.addEmployee(empno, ename, job, salary);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
	public Employee getEmployee(int empno) {
		return empdao.getEmployee(empno);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)	
	public List<Employee> getEmployees() {
		return empdao.getEmployees();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=java.lang.Exception.class)

	public boolean deleteEmployee(int empno) {
		return empdao.deleteEmployee(empno);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=java.lang.Exception.class)
	public boolean updateEmployee(int empno,double sal) {
		return empdao.updateEmployee( empno, sal);
	}
	
}

