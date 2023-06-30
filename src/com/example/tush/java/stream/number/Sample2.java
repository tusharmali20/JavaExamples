package com.example.tush.java.stream.number;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sample2 {
	public static void main(String[] args) {
		int[] ar ={1, 2, 2, 3, 4, 4, 4, 5};
		List<int[]> list=Arrays.asList(ar);
		
		//Converting int[] to list
		List<Integer> list1 = Arrays.stream(ar).boxed().toList();
		Map<Object, Object> occ = Arrays.stream(ar).boxed().collect(Collectors.toMap(k->k, v->v));
		Map<Object, Long> occ1 = Arrays.stream(ar).boxed()
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
	}
}
