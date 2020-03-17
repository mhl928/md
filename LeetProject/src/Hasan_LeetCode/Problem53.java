package Hasan_LeetCode;

/*
 * Maximum Subarray:
 * Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and 
conquer approach, which is more subtle.
 */

public class Problem53 {
	
	public static void main(String[] args) {
		int[] arr= {-2,1,-3,4,-1,2,1,-5,4,3,-4,5,2,-7,3,-2,3,-4,2,3,7,12,-7};
		int max=maximumSubarry(arr);
		System.out.println("\nMaximum contiguous sum is= "+max);
	}
	
	/*public static int maximumSubarry(int[] arr) {
		//int globalMax=Integer.MIN_VALUE;
		int globalMax=arr[0];
		int localMax=arr[0];
		for(int i=0;i<arr.length;i++) {
			localMax=Math.max(arr[i], localMax+arr[i]);
			globalMax=Math.max(localMax, globalMax);
		}
		return globalMax;
	}*/
	
	// Java program to print largest  
	// contiguous array sum 
	
	  
	    static int maximumSubarry(int a[]) 
	    { 
	        int globalMax = a[0];//nteger.MIN_VALUE, 
	        int localMax = a[0];
	        int start = 0,  end = 0, s = 0; 
	  
	        for (int i = 0; i < a.length; i++)  
	        { 
	            localMax += a[i]; 
	  
	            if (globalMax < localMax)  
	            { 
	                globalMax = localMax; 
	                start = s; 
	                end = i; 
	            } 
	  
	            if (localMax < 0)  
	            { 
	                localMax = 0; 
	                s = i + 1; 
	            } 
	        } 
	        printSubarray(a,start,end);
	        return globalMax;
	    } 
	    
	    public static void printSubarray(int[] a,int start, int end) {
	    	System.out.print("Contiguous subarray is: {");
	    	for(int i=start;i<end+1;i++) {
	    		if(i==start) {
	    		System.out.print(""+a[i]);
	    		}
	    		else
	    		{
	    		System.out.print(", "+a[i]);	
	    		}
	    	}
	    	System.out.print("}");
	    }
	    

}
