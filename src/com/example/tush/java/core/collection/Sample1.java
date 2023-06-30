package com.example.tush.java.core.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sample1 {
	public static void main(String[] args) {
		final int MAX_VAL = 100;
		List<Integer> linkedList = new LinkedList<Integer>();
		List<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < MAX_VAL; i++) {
			linkedList.add(i);
			arrayList.add(i);
		}
		long time = System.nanoTime();
		long end = System.nanoTime();
		// for (int i = 0; i < MAX_VAL; i++) {
		linkedList.add(MAX_VAL / 2, 12);
		end = System.nanoTime();
		// }
		System.out.println("LL time: " + (end - time));
		time = System.nanoTime();
		// for (int i = 0; i < MAX_VAL; i++) {
		arrayList.add(MAX_VAL / 2, 12);
		// }
		System.out.println("AL time: " + (end - time));

		time = System.nanoTime();
		linkedList.add(MAX_VAL / 2, 12);
		System.out.println("LL time: " + (end - time));
		time = System.nanoTime();
		arrayList.add(MAX_VAL / 2, 12);
		System.out.println("AL time: " + (end - time));

		time = System.nanoTime();
		arrayList.contains(16);
		end = System.nanoTime();
		System.out.println("AL time: " + (end - time));
		time = System.nanoTime();
		linkedList.contains(16);
		end = System.nanoTime();
		System.out.println("LL time: " + (end - time));
	}
}
