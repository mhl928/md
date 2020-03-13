package Hasan_LeetCode;
/*
 * First Missing number
 * Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
 */

public class Problem41 {
	
	public static void main(String[] args) {
		//int[] num= {2,-1,1,4,8,-4,8,9,7,2,0};
		int[] num= {1,2,3};
		int n=missingNumber(num);
			System.out.println("Missing minimum positive number: " +n);
	}
	
	public static int missingNumber(int[] num) {
		int n=num.length;
		int containsOne=0;
		//step 1;
		for(int i=0;i<n;i++) {
			if(num[i]==1) {
				containsOne=1;
			}
		   else if(num[i]<=0||num[i]>n) { // now all elements in array are between 1 to arr.length
				
				num[i]=1;
			}
		}
		if(containsOne==0) {
			return 1;
		}
		
		//step 2: making the positive number negative
		for(int i=0;i<n;i++) {
			int index= Math.abs(num[i])-1;
			if(num[index]>0) {
				num[index]= -1*num[index];
			}	
		}
		
		//step 3:
		for(int i=0;i<n;i++) {
			if(num[i]>0) {
				return i+1;
			}
		}
		//for case: {1,2,3} ->4 
		return n+1;
	}

}
