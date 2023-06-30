package com.example.tush.java.stream.string;

public class Sample2 {

	public static void main(String[] args) {

		String s = "a!!!b.c.d,e'f,ghi@#";
		// String s = "Tu@sha$r";
		System.out.println(m1(s));
		System.out.println(m2(s));
	}

	static void reverseString(String s) {

	}

	//Reverse string keeping special charactes at same position
	static String m1(String s) {
		StringBuilder sb = new StringBuilder();
		int r = s.length() - 1;
		int l = 0;
		while (l < s.length()) {
			if (!Character.isAlphabetic(s.charAt(l))) {
				sb.append(s.charAt(l));
				l++;
			} else if (!Character.isAlphabetic(s.charAt(r))) {
				r--;
			} else {
				sb.append(s.charAt(r));
				r--;
				l++;
			}
		}
		return sb.toString();

	}

	static String m2(String s) {
		char str[] = s.toCharArray();
		int r = str.length - 1, l = 0;

		// Traverse string from both ends until 'l' and 'r'
		while (l < r) {
			// Ignore special characters
			if (!Character.isAlphabetic(str[l]))
				l++;
			else if (!Character.isAlphabetic(str[r]))
				r--;

			// Both str[l] and str[r] are not spacial
			else {
				char tmp = str[l];
				str[l] = str[r];
				str[r] = tmp;
				l++;
				r--;
			}
		}
		return String.valueOf(str);
	}
}
