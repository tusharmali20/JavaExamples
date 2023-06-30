package com.example.tush.java.stream.string;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxRange {
	public static void main(String[] args) {
		maxRangeCal(6, "LL???R");
	}

	private static void maxRangeCal(int n, String s) {
		//List<String> list = s.chars().map(i -> (char) i).map(ch -> String.valueOf(ch))
		//		.collect(Collectors.toList());
		List<Character> list = s.chars().mapToObj(i -> (char) i)
				.collect(Collectors.toList());
		System.out.println(list);
		Map<Character, Long> mcl = s.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(mcl);
		List<String> list1 = s.chars().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.toList());
		System.out.println(list1);
		Map<String, List<String>> map = s.chars().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.groupingBy(Function.identity()));
		System.out.println(map);
		if(map.get("L").size()>=map.get("R").size()) {
			int result = map.get("L").size()+map.get("?").size()-map.get("R").size();
			System.out.println(result);
		}
		Map<String, Long> map1 = s.chars().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map1);
		if(map1.get("L")>=map1.get("R")) {
			int res = (int) (map1.get("L") + map1.get("?")-map1.get("R"));
			System.out.println(res);
		}
		
	}
}
