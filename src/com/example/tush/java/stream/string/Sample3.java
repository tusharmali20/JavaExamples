package com.example.tush.java.stream.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Sample3 {

	public static void main(String[] args) {
		String s = "[[](){p(m)l}]";
		System.out.println(m4(s));
		System.out.println(m1(s));
	}

	static boolean m4(String s) {
		Map<String, String> map = new HashMap<>();
		map.put("(", ")");
		map.put("{", "}");
		map.put("[", "]");
		int i = s.length() - 1;
		int j = 0;
		char sar[] = s.toCharArray();
		while (j < i / 2) {
			if (!map.containsKey(String.valueOf(sar[j]))) {
				j++;
			}
			if (!map.containsValue(String.valueOf(sar[i]))) {
				i--;
			}
			if (String.valueOf(sar[i]).equals(map.get(String.valueOf(sar[j])))) {
				i--;
				j++;
			} else {
				return false;
			}
		}
		return true;
	}

	static boolean m1(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if (x == '[' || x == '{' || x == '(') {
				stack.push(x);
				continue;
			} else if (!(x == ']' || x == '}' || x == ')')) {
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}
}
