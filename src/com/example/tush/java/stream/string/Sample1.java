package com.example.tush.java.stream.string;

import java.util.OptionalInt;

public class Sample1 {

	static boolean findChar(String s, char ch) {
		OptionalInt c = s.chars().map(i -> (char) i).filter(i -> i == ch).findAny();
		if (c.isPresent()) {
			System.out.println(c.getAsInt());
			System.out.println((char) c.getAsInt());
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		boolean r = findChar("Tushar", 'v');
		System.out.println(r);
	}
}
