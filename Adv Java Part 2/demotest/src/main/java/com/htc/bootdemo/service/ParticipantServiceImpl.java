package com.htc.bootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.htc.bootdemo.dao.ParticipantDAO;
import com.htc.bootdemo.model.Participant;


@Service
public class ParticipantServiceImpl implements ParticipantService
{
	@Autowired
	ParticipantDAO empdao;
	
	public ParticipantDAO getEmpdao() {
		return empdao;
	}
	public void setEmpdao(ParticipantDAO empdao) {
		this.empdao = empdao;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=java.lang.Exception.class)
	public boolean addEmployee(Participant emp) {
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
	public Participant getEmployee(int empno) {
		return empdao.getEmployee(empno);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)	
	public List<Participant> getEmployees() {
		return empdao.getEmployees();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=java.lang.Exception.class)

	public boolean deleteEmployee(int empno) {
		return empdao.deleteEmployee(empno);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=java.lang.Exception.class)
	public boolean updateEmployee(Participant newemp) {
		return empdao.updateEmployee(newemp);
	}
	
}

