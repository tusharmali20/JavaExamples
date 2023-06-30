package com.example.tush.java.stream.number;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample3 {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6 }; // first array
		int[] arr2 = { 7, 8, 9, 0 }; // second array
		int[] arr3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }; // resultant array
		mergeArrays(arr1, arr2);
		mergeArrays1(arr1, arr2);
	}

	private static void mergeArrays(int[] arr1, int[] arr2) {
		int fal = arr1.length; // determines length of firstArray
		int sal = arr2.length; // determines length of secondArray
		int[] result = new int[fal + sal]; // resultant array of size first array and second array
		System.arraycopy(arr1, 0, result, 0, fal);
		System.arraycopy(arr2, 0, result, fal, sal);
		System.out.println(Arrays.toString(result)); // prints the resultant array
	}

	private static void mergeArrays1(int[] arr1, int[] arr2) {
		Object[] mergedArray = Stream.of(arr1, arr2).flatMap(Stream::of).toArray();
		System.out.println("Merged array: " + Arrays.toString(mergedArray));
	}

}
