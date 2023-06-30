package com.example.tush.java.stream.number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SampleTest1234 {
	static final int MAX_CHAR = 256;

	public static void main(String[] args) {
		String input = "Tushar Bhikhabhai Mali";
		String str = "Pneumonoultramicroscopicsilicovolcanoconiosis"; // lung disease
		countChars(input);
		getOccuringChar(str);
		getOccuringChar1(input);
		getOccuringChar2(input);
	}

	private static void countChars(String str) {
		str.chars().boxed()
				// .mapToObj(c->Character.valueOf(c))
				// .collect(Collectors.groupingBy(v))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((k, v) -> System.out.println(Character.toString(k) + " - " + v));
	}

	static void getOccuringChar(String str) {
		// creating an array of size 256 (ASCII_SIZE)
		int count[] = new int[MAX_CHAR];
		// finds the length of the string
		int len = str.length();
		// initialize count array index
		for (int i = 0; i < len; i++)
			count[str.charAt(i)]++;
		// create an array of given String size
		char ch[] = new char[str.length()];
		for (int i = 0; i < len; i++) {
			ch[i] = str.charAt(i);
			int find = 0;
			for (int j = 0; j <= i; j++) {
				// if any matches found
				if (str.charAt(i) == ch[j])
					find++;
			}
			if (find == 1)
				// prints occurrence of the character
				System.out.println(
						"The occurrence of " + str.charAt(i) + " is: " + count[str.charAt(i)]);
		}
	}

	static void getOccuringChar1(String str) {
		HashMap<Character, Integer> charCount = new HashMap<>();
		for (int i = str.length() - 1; i >= 0; i--) {
			if (charCount.containsKey(str.charAt(i))) {
				int count = charCount.get(str.charAt(i));
				charCount.put(str.charAt(i), ++count);
			} else {
				charCount.put(str.charAt(i), 1);
			}
		}
		System.out.println(charCount);
	}

	static void getOccuringChar2(String str) {
		// Ordered by String
		Map<String, Long> result = Arrays.stream(str.split(""))
				// .map(String::toLowerCase)
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
		// Ordered by characters
		Map<String, Long> result1 = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(s -> s, TreeMap::new, Collectors.counting()));
		System.out.println(result);
		System.out.println(result1);
		long count = str.chars().filter(ch -> ch == 'e').count();
		
	}

}
