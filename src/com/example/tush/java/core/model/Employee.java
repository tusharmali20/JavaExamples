package com.example.tush.java.core.model;

//https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
public class Employee implements Comparable<Object> {

	private Long id;
	private Integer age;
	private String name;
	private Long salary;

	public Employee(Long id, Integer age, String name, Long salary) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Employee) {
			Employee emp=(Employee)o;
			return emp.getAge().compareTo(this.age);
		}
		return 0;
	}

}
