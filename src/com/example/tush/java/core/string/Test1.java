package com.example.tush.java.core.string;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Tushar", "Tushar123", "123", "Mali", "Vih@");
		alphabets(list);
		alphabets1(list);
		alphabets2(list);
	}

	static void alphabets(List<String> list) {
		Predicate<String> p = s -> s.matches("[A-Za-z]+");
		Optional<String> result = list.stream().filter(p).findAny();

		System.out.println(result.isPresent() ? result.get() : null);
	}
	
	static void alphabets1(List<String> list) {
		Predicate<String> p = s -> {return s.chars().mapToObj(item -> (char) item).allMatch(c->Character.isAlphabetic(c));};
		list.stream().filter(p).forEach(System.out::println);
	}
	
	static void alphabets2(List<String> list) {
		//Predicate<String> p = s -> {return s.chars().mapToObj(item -> (char) item).allMatch(c->Character.isAlphabetic(c));};
		list.stream().flatMap(s->s.chars().mapToObj(item -> (char) item).filter(c->Character.isAlphabetic(c))).forEach(System.out::println);
	}
}
