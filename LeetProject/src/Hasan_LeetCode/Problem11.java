package Hasan_LeetCode;

public class Problem11 {

	public static void main(String[] args){
		int[] arr={1,8,6,2,5,4,8,3,7};
		int maxArea=maxArea(arr);
		System.out.println("Maximum area = "+maxArea);
	}
	
	
	
	// brute force approach  O(n^2)
	
	   /* public static int maxArea(int[] height) {
	        int maxarea = 0;
	        for (int i = 0; i < height.length; i++)
	            for (int j = i + 1; j < height.length; j++)
	                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
	        return maxarea;
	    }
	    */
	
	//Two pointer approach: O(n)
	
	public static int maxArea(int[] height){
		int maxArea=0;
		int leftX=0; // first x coordinate 
		int rightX=height.length-1; // last x coordinate
		
		/*
		 * track the maxArea for the first line and the last line and then second and second last 
		 * and so on...
		 */
		while(leftX<rightX){
			maxArea=Math.max(maxArea, Math.min(height[leftX], height[rightX])*(rightX-leftX));
			
			if(height[leftX]<height[rightX]){
				leftX++;
			}
			else{
				rightX-- ;
			}
		}
		
		
		return maxArea;
	}
	    
	    
	}

