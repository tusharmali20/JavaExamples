package com.example.tush.java.core.practice;

import java.util.Arrays;

public class ClosetToZero {
	public static void main(String[] args) {
		int[] nums = { -2, 7, 11, -4, 6, 2};
		// int[] nums={-5, 3, 2, 7, 4, -3, -2, -10};
		Arrays.sort(nums);
		int current = 0;
		int near = nums[0];
		for (int i : nums) {
			current=i*i;
			if (current <= (near * near)) {
				near = i;
			}
		}
		System.out.println(near);
		near = nums[0];
		for (int i : nums) {
			current=Math.abs(i);
			if (current <= Math.abs(near)) {
				near = i;
			}
		}
		System.out.println(near);
	}
}
