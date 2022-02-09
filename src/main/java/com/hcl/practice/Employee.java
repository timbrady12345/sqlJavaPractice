package com.hcl.practice;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Employee")
@Entity(name = "Emp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//	@GenericGenerator(name = "native", strategy = "native")
	//EmpID,EmpName,DOB,Salary,Age
	@Column(name = "EMPID")
	private Long empId;

	@Column(name = "EMPNAME")
	private String empName;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "SALARY")
	private Long salary;
	
	@Column(name = "AGE")
	private Long age;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [EmployeeID=" + empId + ", EmployeeName=" + empName + ", DateOfBirth=" + dob
				+ ", salary=" + salary + " age=" + age + "]";
	}
	
}
