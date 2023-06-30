package com.example.tush.java.core.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample1 {

	public static void main(String[] args) {
		String str[] = { "aaa", "bbb", "ddd", "ccc", "Tushar", "Mali", "Viha", "Lalla" };
		int[][] qr = { { 3, 3, 2 }, { 2, 5, 6 }, { 5, 7, 8 } };
		System.out.println(Arrays.toString(chatAt(str, 3, qr)));
	}

	public static char[] chatAt(String[] str, int q, int query[][]) {
		char[] result = new char[q];
		// IntStream stream = Arrays.stream(query).flatMapToInt(x -> Arrays.stream(x));
		for (int i = 0; i < query.length; i++) {
			String s = "";
			for (int j = 0; j < query[i].length; j++) {
				// System.out.println(i+"-"+j+"="+query[i][j]);
				if (j == 0) {
					s = joinStrings(str, query[i][j] - 1, query[i][j + 1] - 1);
					continue;
				}
			}
			result[i] = s.charAt(query[i][2]);
		}
		return result;
	}

	static String joinStrings(String[] str, int start, int end) {
		int i = start;
		StringBuilder sb = new StringBuilder();
		while (i <= end) {
			sb.append(str[i]);
			i++;
		}
		String result = sb.toString();
		char[] chars = result.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	static void givenString_whenSortJava8_thenSorted(String str) {
		String sorted = str.chars().sorted()
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();

		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		String sorted1 = new String(chars);
		
		str = Stream.of(str.split("")).sorted().collect(Collectors.joining());
	}
}
