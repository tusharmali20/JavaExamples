package com.example.tush.java.stream.number;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test121 {
	
	public static void main(String[] args) {
		int[] Input = {1, 2, 1, 3, 3, 1, 4, 5};
		//int[] Output = {1, 1, 1, 3, 3, 2, 4, 5}
		System.out.println(Arrays.toString(sort(Input)));
	}
	public static int[] sort(int[] a){
		int[] output=new int[a.length];
		Map<Integer, List<Integer>> map = Arrays.stream(a).boxed()
				.collect(Collectors.groupingBy(Function.identity()));
		map.forEach((k, v) -> System.out.println(k + "-" + v));
		
		//Map<Object, Long> map = Arrays.stream(a).boxed()
				//.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		//map.forEach((k, v) -> System.out.println(k + "-" + v));
		
		List<Integer> list=map.values().stream()
				.sorted((l1,l2)->Integer.valueOf(l2.size()).compareTo(Integer.valueOf(l1.size())))
				.flatMap(l -> l.stream())
				.collect(Collectors.toList());
		
		list.forEach(v->System.out.println(v));
		
		//Convert List<Integer> to int array
		output=list.stream().mapToInt(Integer::intValue)
        .toArray();
		return output;
	}
	
}
