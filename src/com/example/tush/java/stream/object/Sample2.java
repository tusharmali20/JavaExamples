package com.example.tush.java.stream.object;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.tush.java.core.model.Employee1;

public class Sample2 {

	public static void main(String[] args) {
		List<Employee1> listOfEmp = new ArrayList<>();

		listOfEmp.add(new Employee1(1, "A", 23, "IT", 100));
		listOfEmp.add(new Employee1(2, "B", 30, "IT", 200));
		listOfEmp.add(new Employee1(3, "C", 29, "SUPPORT", 100));
		listOfEmp.add(new Employee1(4, "D", 43, "SUPPORT", 200));
		listOfEmp.add(new Employee1(5, "E", 27, "HR", 300));
		listOfEmp.add(new Employee1(6, "F", 31, "SUPPORT", 400));
		listOfEmp.add(new Employee1(7, "G", 33, "IT", 500));
		listOfEmp.add(new Employee1(8, "H", 26, "IT", 600));
		listOfEmp.add(new Employee1(9, "I", 23, "HR", 700));

		Comparator<Employee1> bySalary = Comparator.comparing(Employee1::getSalary);

		Map<String, Set<Employee1>> departmentWiseEmployees = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee1::getDept, Collectors.toSet()));
		System.out.println(departmentWiseEmployees);

		int limit = 2;
		Map<String, Object> groupByTeachers = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee1::getDept, Collectors.collectingAndThen(
						Collectors.toList(),
						e -> e.stream().sorted().limit(limit).collect(Collectors.toList()))));
		System.out.println(groupByTeachers);

		Map<String, Object> groupByName = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee1::getDept,
						Collectors.collectingAndThen(Collectors.toList(),
								e -> e.stream().sorted(bySalary).map(Employee1::getName)
										.limit(limit).collect(Collectors.toList()))));
		System.out.println(groupByName);

		// find the highest 2 paid employees in each department
		Map<String, Object> groupByName1 = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee1::getDept,
						Collectors.collectingAndThen(Collectors.toList(),
								e -> e.stream().sorted(bySalary).map(Employee1::getName)
										.limit(limit).collect(Collectors.toList()))));
		System.out.println(groupByName1);

		// find the highest Second paid employees in each department
		Map<String, Object> groupByName2 = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee1::getDept,
						Collectors.collectingAndThen(Collectors.toList(),
								e -> e.stream().sorted(bySalary).skip(1).map(Employee1::getName)
										.limit(1).collect(Collectors.toList()))));
		System.out.println(groupByName2);
	}
}
