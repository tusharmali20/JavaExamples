package com.example.tush.java.stream.number;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test122 {

	public static void main(String[] args) {
		int[] arr= {1,2,3,5,6,7,8,4,2,3,1,3};
		int[] br= {1,2,3,5,9,4,2,3,1,3};
				Map<Integer, Long> map=Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				
				Optional<Long> max = map.values().stream().max((l1,l2)->l1.compareTo(l2));
				System.out.println((max.isPresent())?max.get():0);
				//.forEach((k,v)->System.out.println(k+"-"+v));
				
		Set set=Arrays.stream(arr).boxed().collect(Collectors.toSet());
		List<Integer> list=Arrays.stream(br).boxed().filter(i->set.contains(i)).collect(Collectors.toList());
		
		if(list.size()==9){
			System.out.println("Success");
		}						
	}
}
