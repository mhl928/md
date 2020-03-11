package Hasan_LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * Given an array nums of n integers and an integer target, find three integers in 
 * nums such that the sum is closest to target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Problem16 {

	public static void main(String[] args) {
		int[] num= {2,2,-1,4,0,1,7,-8,6,-8,5,2,3,1,-1,2,2};
		int target=-28;
		int result=threeSumClosest(num,target);
		
			System.out.println(result);
	
				
	}
	
	public static int threeSumClosest(int[] arr, int target){
		Arrays.sort(arr);
		List<List<Integer>> result=new ArrayList<>();
		int sum=arr[0]+arr[1]+arr[2];
		// fix the first element one by one and find others two
		for(int i=0;i<arr.length-2;i++) {
			if(i>=1&& arr[i]==arr[i-1]) { // if two elements for i are same then continue
				continue;
			}
			int left=i+1;
			int right=arr.length-1;
			while(left<right) {
				int thisSum=arr[i]+arr[left]+arr[right];
				if(Math.abs(sum-target)>Math.abs(thisSum-target)) {
					sum=thisSum;
				}
				if(sum==target) {
					while(left+1<right&& arr[left+1]==arr[left]) { //for left if elements are same
						left++;
					}
					while(right-1>left&& arr[right]==arr[right-1]) { //for right if two elements are same
						right--;
					}
					left++;
					right--;
					return sum;
				}
				else if(sum>target) { // obviously needs to go next small number in the list
					right--;
				}
				else {
					left++; // obviously  have to go for next big number in the list
				}
				
			}
			
		}
		
		return sum;
	}

}
