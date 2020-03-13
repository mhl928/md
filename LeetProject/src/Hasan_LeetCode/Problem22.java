package Hasan_LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of 
 * well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class Problem22 {
	
	public static void main(String[] args) {
		
		int n=5;
		List<String> result=wellFromedParentheses(n);
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}
	
	
	public static List<String> wellFromedParentheses(int n){
		List<String> result=new ArrayList<>();
		backtrack(result,"",0,0,n);
		return result;
	}
	
	// think about a breadth first search
	public static void backtrack(List<String> result,String str,int left, int right, int max) {
		if(str.length()==2*max) {
			result.add(str);
			//return;
		}
		if(left<max) {
			backtrack(result,str+"(",left+1, right, max);
		}
		if(right<left) {
			backtrack(result,str+")", left, right+1, max);
		}
	}

}
