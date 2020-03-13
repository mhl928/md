package Hasan_LeetCode;

import java.util.Stack;

/*
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.

<<<<<<< HEAD

=======
>>>>>>> a0ffc0035fd70378f3e39179b78ea584dcdf10f5
An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */

public class Problem20 {
	
	public static void main(String[] args) {
		String s="{[]}([()])";
		if(isValidParen(s)) {
		System.out.println("\n    Parenthesis are well organized");
		}
		else {
		System.out.println("Parenthesis are not organized");
		}
	}
	
	public static boolean isValidParen(String s) {
		if(s.isEmpty()) {
			return false;
		}
		else {
			Stack<Character> stack=new Stack<>();
			for(int i=0;i<s.length();i++) {
				char current=s.charAt(i);
				if(current=='(' || current=='{' || current=='[') {
					stack.push(current);
				}
				else {
					if(stack.isEmpty()) {
					return false;
				}
				char peekChar=stack.peek();
				if((current==')'&& peekChar!='(') || (current=='}'&& peekChar!='{')|| (current==']'&&peekChar!='[')) {
					return false;
				}
				else {
					stack.pop();
				}
		
			}
		 }
		}
		 
		return true;
	}

}
