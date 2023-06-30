package com.example.tush.java.stream.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SampleTest1 {

	public static void main(String[] args) {
		nonRepteatingWord();
		repteatingWord();
	}

	private static void nonRepteatingWord() {
		String str = "There is a sunny day today. We will go for outing today. Outing is a good activity to break monotonous blah. There are many places.";
		Map<String, Long> map = Arrays.stream(str.split(" "))
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
		Optional<String> result = map.entrySet().stream().filter(e -> e.getValue().equals(1l))
				.map(e -> e.getKey()).findFirst();
		if (result.isPresent()) {
			System.out.println(result.get());
		}
	}

	private static void repteatingWord() {
		String str = "There is a sunny day today. We will go for outing today. Outing is a good activity to break monotonous blah. There are many places.";
		Map<String, Long> map = Arrays.stream(str.split(" "))
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
		map.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.forEach(e -> System.out.println(e.getKey() + "-" + e.getValue()));

	}
}

class Employee implements Comparable<Employee> {

	private int id; // employee id

	private String name; // employee.

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		return Integer.valueOf(this.getId()).compareTo(Integer.valueOf(o.getId()));
	}

	@Override
	public int hashCode() {
		return this.getId() * 23;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee e = (Employee) obj;
		if (this.getId() == e.getId() && this.getName().equals(e.getName())) {
			return true;
		}
		return false;
	}
}
/*
 * 1. Use employee class in TreeMap check order is sorted according to
 * implemented logic 2. Add employee class in HashSet, and check if you can
 * again add it or not, it should not add again return false 3. Test equals
 * method with same object and different object for desired results
 */
