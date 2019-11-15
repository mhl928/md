package Hasan_LeetCode;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem3. Given a String, find the length of the longest substring 
 * without repeating characters. Examples: Given "abcabcbb", the answer 
 * is "abc", which the length is 3. Given "bbbbb", the answer is "b", with 
 * the length of 1. Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 */

public class LeetProblem3 {
	
	public static void main(String[] args) {
		String s="abcabcbb";
		int length=lengthOfLongestSubstring(s);
		System.out.println("Lenght= "+length);
		

	}
	public static int lengthOfLongestSubstring(String s) {
		int length=0;
		int n=s.length();
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<=n;j++) {
				if(allUnique(s,i,j)) length=Math.max(length,j-i);
			}
		}
		return length;
	}
	
	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set= new HashSet<>();
		for(int i=start;i<end;i++) {
			Character ch=s.charAt(i);
			if(set.contains(ch)) return false;
			set.add(ch);
		}
		return true;
	}

}
