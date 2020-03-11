package Hasan_LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums 
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */


public class Problem15 {
	
	public static void main(String[] args) {
		int[] num= {2,2,-1,4,0,1,7,7,-8,6,-8,5,2,3,1,-1,2,2};
		int target=15;
		List<List<Integer>> result=threeSum(num,target);
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
				
	}
	
	public static List<List<Integer>> threeSum(int[] arr, int target){
		Arrays.sort(arr);
		List<List<Integer>> result=new ArrayList<>();
		
		// fix the first element one by one and find others two
		for(int i=0;i<arr.length-2;i++) {
			if(i>=1&& arr[i]==arr[i-1]) { // if two elements for i are same then continue
				continue;
			}
			int left=i+1;
			int right=arr.length-1;
			while(left<right) {
				int sum=arr[i]+arr[left]+arr[right];
				if(sum==target) {
					result.add(Arrays.asList(arr[i],arr[left], arr[right]));
					while(left+1<right&& arr[left+1]==arr[left]) { //for left if elements are same
						left++;
					}
					while(right-1>left&& arr[right]==arr[right-1]) { //for right if two elements are same
						right--;
					}
					left++;
					right--;
				}
				else if(sum>target) { // obviously needs to go next small number in the list
					right--;
				}
				else {
					left++; // obviously  have to go for next big number in the list
				}
				
			}
			
		}
		
		return result;
	}

}
