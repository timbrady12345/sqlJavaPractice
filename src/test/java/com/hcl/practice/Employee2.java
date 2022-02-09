package com.hcl.practice;

import java.util.Date;

public class Employee2 {

	private Long id;
	private Long salary;
	private Long age;
	private Date dob;
	private String empName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", salary=" + salary + ", age=" + age + ", dob="
				+ dob + ", empName=" + empName + "]";
	}
}
