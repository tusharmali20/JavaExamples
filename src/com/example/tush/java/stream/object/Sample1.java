package com.example.tush.java.stream.object;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.example.tush.java.core.model.Employee;

public class Sample1 {

	public static void main(String[] args) {

		List<Employee> list = Arrays.asList(new Employee(1L, 20, "abc", 10400L),
				new Employee(2L, 22, "xyz", 10500L), new Employee(3L, 23, "abc", 10300L),
				new Employee(4L, 26, "jkl", 10200l), new Employee(5L, 34, "xyz", 12000l),
				new Employee(6L, 65, "abc", 14000l), new Employee(7L, 43, "jkl", 10500l),
				new Employee(8L, 52, "xyz", 10050l), new Employee(9L, 23, "jkl", 12000l),
				new Employee(10L, 32, "abc", 17000l), new Employee(11L, 29, "jkl", 18000l),
				new Employee(12L, 31, "xyz", 20000l));

		Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);
		Comparator<Employee> byAge = Comparator.comparing(Employee::getAge);
		
		list.stream().sorted().collect(Collectors.groupingBy(e->e.getName()))
		.forEach((k,v)->System.out.println("K "+k+" - V "+v));
		
		//Top 2 aged employee in each department
		list.stream().sorted().collect(Collectors.groupingBy(e->e.getName()))
				.entrySet()
				.stream()
                .collect(Collectors.toMap(Map.Entry::getKey,v->v.getValue().subList(0, 2),(a,b) -> a))
                .forEach((k,v)->System.out.println("K "+k+" - V "+v));
		
		list.stream().sorted().forEach(System.out::println);
		Map<Object, Object> topEmployees = list.stream()
				.collect(Collectors.groupingBy(e -> e.getName(),
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparingInt(e -> e.getAge())),
								Optional::get)));
		topEmployees.forEach((k, v) -> System.out.println(k + "-" + v));

		Map<String, Employee> topEmployee = list.stream()
				.collect(Collectors.toMap(e -> e.getName(),
				e -> e, BinaryOperator.maxBy(Comparator.comparingInt(e -> e.getAge()))));
		topEmployee.forEach((k, v) -> System.out.println(k + "-" + v));
		
		Map<Object, Object> retVal = list.stream()
		        .collect(Collectors.groupingBy(Employee::getName,
		                Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
		        .entrySet().stream()
		        .collect(Collectors.toMap(Map.Entry::getKey,
		                e -> e.getValue().map(Employee::getSalary)));
		retVal.forEach((k, v) -> System.out.println(k + "-" + v));
		
		Map<String, Map<Long, Set<Employee>>> map = list.stream()
			    .collect(Collectors.groupingBy(Employee::getName, 
			        Collectors.groupingBy(Employee::getId, Collectors.toSet())));
		System.out.println(map);
	}

}
