package com.htc.entity;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<EmployeeComparator>
{

	public EmployeeComparator() {
		super();
	}

	private int empId;
	private String empName;
	private int age;
	private double salary;
	
	public EmployeeComparator(int empId, String empName, int age, double salary)
	{
		super();
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", age=" + age + ", salary=" + salary + "]";
	}

	@Override
	public int compare(EmployeeComparator o1, EmployeeComparator o2) {
		// TODO Auto-generated method stub
		return (this.empId - o2.empId);
	}
	public static Comparator<EmployeeComparator> SalaryComparator = new Comparator<EmployeeComparator>() {

        @Override
        public int compare(EmployeeComparator e1, EmployeeComparator e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };

    /**
     * Comparator to sort employees list or array in order of Age
     */
    public static Comparator<EmployeeComparator> AgeComparator = new Comparator<EmployeeComparator>() {

        @Override
        public int compare(EmployeeComparator e1, EmployeeComparator e2) {
            return e1.getAge() - e2.getAge();
        }
    };

    /**
     * Comparator to sort employees list or array in order of Name
     */
    public static Comparator<EmployeeComparator> NameComparator = new Comparator<EmployeeComparator>() {

        @Override
        public int compare(EmployeeComparator e1, EmployeeComparator e2) {
            return e1.getEmpName().compareTo(e2.getEmpName());
        }
    };

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeComparator other = (EmployeeComparator) obj;
		if (empId != other.empId)
			return false;
		return true;
	}
}
