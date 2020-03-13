package Hasan_LeetCode;
/*
 * 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */

public class Problem21 {
	
	public static void main(String[] args){
		int[] arra={2,7,9};
		int[] arrb={1,3,4};
		int[] arrc=mergeSortedArray(arra,arrb);
		for(int i=0;i<arrc.length;i++){
			System.out.print(" "+arrc[i]);
		}
	}
	// Approach1: Arrays
	
	public static int[] mergeSortedArray(int[] arr1, int[] arr2){
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
		return arr;

   }
	
	//
	//approach2: Linked List
	
	
}
