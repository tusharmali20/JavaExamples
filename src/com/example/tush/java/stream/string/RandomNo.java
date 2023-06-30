package com.example.tush.java.stream.string;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomNo {
	public static void main(String[] args) {
		IntStream intStream = IntStream.range(7, 15);
		Stream<Integer> i=intStream.mapToObj(a->a);
		i.forEach(System.out::println);
		//List<Integer> list = intStream.mapToObj(i->i).collect(Collectors.toList());
		//list.forEach(System.out::println);
		IntStream intStream1 = IntStream.range(7, 20);
		Stream<String> s = intStream1.mapToObj(a -> Integer.toBinaryString(a));
		s.forEach(System.out::println);
	}
}
