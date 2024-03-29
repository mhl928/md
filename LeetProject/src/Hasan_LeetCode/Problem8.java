package Hasan_LeetCode;
/*
 * Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary 
until the first non-whitespace character is found. Then, starting from this character,
takes an optional initial plus or minus sign followed by as many numerical digits as 
possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, 
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace 
characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit 
signed integer range: If the numerical value is out of the range of 
representable values, INT_MAX or INT_MIN  is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
 * 
 */
public class Problem8 {
	public static void main(String[] args){
		
		String s="   -21474499dgdfgsd5467";
		int num=myAtoi(s);
		System.out.println("String = "+s+" , Converted Integer = "+num);
		
		}
	
	public static int myAtoi(String s){
		// escape white space
		s=s.trim();
		if (s==null || s.length()==0) return 0;
		
		int result=0;
		int index=0;
		//handle sign bit
		boolean isNegative=false;
		if(s.charAt(0)=='+'|| s.charAt(0)=='-'){
			index++;
		}
		if(s.charAt(0)=='-'){
			isNegative=true;
		}
		
		//handle numbers
		for(int i=index;i<s.length();i++){
			if(s.charAt(i)<'0'||s.charAt(i)>'9'){
				break;
			}
			int digit= (int)(s.charAt(i)-'0');
			if(!isNegative&&result>(Integer.MAX_VALUE-digit)/10) return Integer.MAX_VALUE;
			else if(isNegative&&result<(Integer.MIN_VALUE+digit)/10) return Integer.MIN_VALUE;
			
			result=result*10+digit;
		}
		
		if(isNegative) result=-result;
		
		// handle out of range
		
		
		return result;
	}
 }

	

