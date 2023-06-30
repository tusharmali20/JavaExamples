package com.example.tush.java.core.model;

import java.util.Objects;

public class Employee1 implements Comparable<Employee1> {
	private Integer id;
	private String name;
	private Integer age;
	private String dept;
	private Integer salary;

	public Employee1(Integer id, String name, Integer age, String dept, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee1 other = (Employee1) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept
				+ ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee1 o) {
		if (this.getName().compareTo(o.getName()) == 0) {
			return this.getId().compareTo(o.getId());
		} else {
			this.getName().compareTo(o.getName());
		}
		return 0;
	}
}