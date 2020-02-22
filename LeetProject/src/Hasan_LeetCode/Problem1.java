package Hasan_LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of integers, return indices of the two numbers such that 
 * they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you 
 * may not use the same element twice.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */


//Solution 1: Brute Force Approach
// Time complexity : O(n^2)

/*
public class Problem1 {
 public static void main(String[] args) {
	 
	 int[] arr= {1,5,7,6,8,10};
	 int[] output=twoSum(arr);
	 for(int i=0;i<output.length;i++) {
	 System.out.print(" "+output[i]);
	 }
 }
	
	public static int[] twoSum(int[] arr) {
		int target=9;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]==target-arr[i])
					return new int[] {i,j};
			}
		}
	throw new IllegalArgumentException("No two sum solution");
	}
	
}
*/

//Solution 2: Using HashMap
// Time complexity: O(n)

public class Problem1{
	
	public static void main(String[] args) {
		 
		 int[] arr= {1,5,7,6,8,12};
		 int target=8;
		 int[] output=twoSum(arr,target);
		 for(int i=0;i<output.length;i++) {
		 System.out.print(" "+output[i]);
		 }
	 }
	
	public static int[] twoSum(int[] arr, int target) {
		Map<Integer, Integer> map= new HashMap();
		Set<Integer> hashSet= new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i],i);
			hashSet.add(arr[i]); // putting elements in a set to avoid duplication
		}
		if(arr.length!=hashSet.size())
		{//System.err.println("Elements are not distinct");
		throw new IllegalArgumentException("Elements in array are not distinct");
		 
		}
		
		for(int i=0;i<arr.length;i++) {
			 
			int complement=target-arr[i];
			if(map.containsKey(complement)&& map.get(complement)!=i) {
				return new int[] {i, map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum Solution");
	}
	
}
