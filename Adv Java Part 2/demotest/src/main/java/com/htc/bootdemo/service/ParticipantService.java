package com.htc.bootdemo.service;

import java.util.List;

import com.htc.bootdemo.model.Participant;

public interface ParticipantService
{
	public boolean addEmployee(Participant emp) ;
	public boolean addEmployee(int empno, String ename, String job, double salary);
	public Participant getEmployee(int empno) ;
	public List<Participant> getEmployees();
	public boolean deleteEmployee(int empno);
	public boolean updateEmployee(Participant newemp);
}
