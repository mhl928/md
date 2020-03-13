package Hasan_LeetCode;


/*
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity 
 * should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * Example 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */

public class Problem4 {
	
	public static void main(String[] args){
		int[] arr3={3,2,9,1,6,2,8,3,5};
		int[] arr1= {1,2,9};
		int[] arr2= {3,4,8};
		mergesort(arr3,0,arr3.length-1);
		
		for(int i=0;i<arr3.length;i++){
			System.out.print(" "+arr3[i]);
		}
		double median=findMedian(arr3,arr2);
		System.out.println("\nMedian is= "+median);
		
	}
	
	// time complexity O(n)
	
	public static double findMedian(int[] arr1, int[] arr2){
		
		int i=0,j=0,k=0;
		int length1=arr1.length, length2=arr2.length;
		int m= (length1+length2)/2; 
		int[] arr= new int[length1+length2]; 
		
		// merge the arrays arr1, arr2 int arr
		while(i<length1 && j<length2){
			if(arr1[i]<=arr2[j]){
				arr[k]=arr1[i];
				i++;
			}
			else{
				arr[k]=arr2[j];
				j++;
			}
			k++;
		}
		// if arr1 has more elements
		while(i<length1){
			arr[k]=arr1[i];
			i++; 
			k++;
		}
		// if arr2 has more elements
		while(j<length2){
			arr[k]=arr2[j];
			j++;
			k++;
		}
		
		// check the number of elements in arr
		if((length1+length2)%2==0){ 
			return (double) (arr[m-1]+arr[m])/2; // median for even
		}
		else{
			return (double) arr[m]; // median for odd
		}
	}
	
	//practicing mergesort
	
public static void merge(int[] arr, int left, int middle, int right){
		
		int i,j,k;
		int length1=middle-left+1; // left half: middle-(left-1)
		int length2= right-middle;
		int[] arr1= new int[length1];
		int[] arr2= new int[length2];
		
		  for (i = 0; i < length1; i++) {
	        arr1[i] = arr[left + i]; 
		  }
	    for (j = 0; j < length2; j++) {
	        arr2[j] = arr[middle + 1+ j]; 
	      }
		i=0;
		j=0;
	    k=left;
	    while(i<length1 && j<length2){
			if(arr1[i]<=arr2[j]){
				arr[k]=arr1[i];
				i++;
			}
			else{
				arr[k]=arr2[j];
				j++;
			}
			k++;
		}
		while(i<length1){
			arr[k]=arr1[i];
			i++; 
			k++;
		}
		while(j<length2){
			arr[k]=arr2[j];
			j++;
			k++;
		}
		
	}
	public static void mergesort(int[]arr, int left, int right){
		
		if(left<right){
			int middle=left+(right-left)/2;
			mergesort(arr,left,middle);
			mergesort(arr,middle+1,right);
			merge(arr,left,middle,right);
			
		}
	}

	
	
	
}





















