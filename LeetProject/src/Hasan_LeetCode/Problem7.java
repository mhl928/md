package Hasan_LeetCode;

/*
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Assume we are dealing with an environment which could only store integers
 Note: within the 32-bit signed integer range:  -2^31 to 2^31-1 .For the purpose 
 of this problem, assume that your function returns 0 when the reversed integer overflows.
 */


public class Problem7 {

	public static void main(String[] args) {
		
		int x=-3754440;
		int rev= reverseInteger(x);
		System.out.println("Reveres of "+x+" is = "+rev);
		
		}
		
		public static int reverseInteger(int x){
			int reverse=0;
			
			while(x!=0){
				int pop= x%10;
				x/=10;
				//integer max value= 2147483647
	            //integer min value= -2147483648
	           if(reverse>Integer.MAX_VALUE/10 || reverse==Integer.MAX_VALUE/10 && pop>7) return 0;
	           if(reverse<Integer.MIN_VALUE/10 || reverse==Integer.MIN_VALUE/10 && pop<-8) return 0;
			   
	           reverse=reverse*10+pop;
			}
			
			return reverse;
		}

	}
