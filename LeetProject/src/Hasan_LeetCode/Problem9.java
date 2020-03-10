package Hasan_LeetCode;

/*
 * Determine whether an integer is a palindrome. An integer is a 
 * palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. 
Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 * 
 */

public class Problem9 {
	
	public static void main(String[] args){
		int x=1234321;
		boolean bo= isPalindromeNumber(x);
		System.out.println("Is "+x+" palindrome? Answer = "+bo);
	}

	
	public static boolean isPalindromeNumber(int x){
		//check special case
		if(x<0||(x%10==0 && x!=0)) return false;
		
		// reveret the last half digits of the number
		
		int revertedNum=0;
		while(x>revertedNum){
			revertedNum=revertedNum*10+x%10;
			x/=10;
		}
		
		return x==revertedNum||(x==revertedNum/10); // for both even and odd palindrome
		
	}

}
