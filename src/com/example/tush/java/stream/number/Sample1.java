package com.example.tush.java.stream.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample1 {
	public static void main(String[] args) {
		int[] arr = { 1, 67, 2, 8, 5, 4, 7, 7, 5, 7 };
		m1();
		m2();
		m3();
		m4();
		System.out.println(countDigit(7, Arrays.stream(arr).boxed().toList()));
	}

	static void m1() {
		int[] arr = { 1, 6, 2, 8, 5, 4, 7, 7, 5, 7 };
		Arrays.stream(arr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll).stream()
				.collect(Collectors.groupingBy(s -> s)).forEach((k, v) -> System.out.println(k + " " + v.size()));
	}

	static void m2() {
		int[] arr = { 1, 6, 2, 8, 5, 4, 7, 7, 5, 7 };
		Arrays.stream(arr).boxed().collect(Collectors.groupingBy(s -> s))
				.forEach((k, v) -> System.out.println(k + "+" + v));
		
		Arrays.stream(arr).boxed().sorted((a1,a2)->a1.compareTo(a2))
		.collect(Collectors.groupingBy(a->a)).forEach((k,v)->System.out.println(k + " " + v));
		
		Arrays.stream(arr).boxed().sorted((a1,a2)->a1.compareTo(a2))
		.collect(Collectors.toMap(a->a, Function.identity()
				, (existing, replacement) -> existing))
		.forEach((k,v)->System.out.println(k + " " + v));
	}

	static void m3() {
		int[] arr = { 1, 6, 2, 8, 5, 4, 7, 7, 5, 7 };
		Map<Object, Long> occurrences = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		occurrences.forEach((k, v) -> System.out.println(k + "-" + v));
	}

	static void m4() {
		int[] arr = { 1, 6, 2, 8, 5, 4, 7, 7, 5, 7 };
		Map<Integer, Object> map1 = Arrays.stream(arr).boxed()
				.collect(Collectors.collectingAndThen(Collectors.groupingBy(n -> n, Collectors.counting()),
						map -> map.entrySet().stream().filter(n -> n.getValue() > 1)
								.collect(Collectors.toMap(Entry::getKey, Entry::getValue))));
		System.out.println(map1.toString());

		// Solution 2 [Improved from Dici's suggestion]
		int[] arr1 = { 1, 6, 2, 8, 5, 4, 7, 7, 5, 7, 2 };
		Map<Integer, Long> map2 = Arrays.stream(arr1).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map2.values().removeIf(n -> n < 2);
		System.out.println(map2.toString());
	}

	public static long countDigit(int target, List<Integer> numbers) {
		return numbers.stream().map(Object::toString) // Convert each number to string
				.collect(Collectors.joining()) // Join all of them into single string
				.chars() // Give me a stream of its characters
				.filter(c -> c == Character.forDigit(target, 10)) // I just want the ones that are the same as my target
				.count(); // How many of them are there?
	}

}
