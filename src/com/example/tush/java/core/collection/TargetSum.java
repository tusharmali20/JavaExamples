package com.example.tush.java.core.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {
	//Input: nums = [2,7,11,15], target = 9
	//Output: [0,1]
	public static void main(String[] args) {
		int[] nums= {2,7,11,15,20,4,6};
		int target= 11;
		System.out.println(Arrays.toString(targetSumArr(nums, target)));
	}
	
	static int[] targetSumArr(int[] nums, int target) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0; i<nums.length;i++){
			if(map.get(target-nums[i])!=null){
				System.out.println(map.get(target-nums[i])+","+i);
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
