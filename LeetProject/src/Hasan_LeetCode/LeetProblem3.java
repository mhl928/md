package Hasan_LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Problem3. Given a String, find the length of the longest substring 
 * without repeating characters. Examples: Given "abcabcbb", the answer 
 * is "abc", which the length is 3. Given "bbbbb", the answer is "b", with 
 * the length of 1. Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 */

//Approach 1: Brute Force; Time complexity O(n^3)

public class LeetProblem3 {
	
	public static void main(String[] args) {
		//String s="abcabcbb";
		String s="pwwkew";
		int length=lengthOfLongestSubstring(s);
		System.out.println("Lenght= "+length);
		int length1=lengthOfSubstring(s);
		System.out.println("Lenght= "+length1);
		

	}
	public static int lengthOfLongestSubstring(String s) {
		int length=0;
		int n=s.length();
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<=n;j++) {
				if(allUnique(s,i,j)) 
					length=Math.max(length,j-i);
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

	//Approach 2: Sliding window using HashMap; Time Complexity O(n)
	
	public static int lengthOfSubstring(String s) {
		int length=0;
		int n=s.length();
		Map<Character, Integer> map=new HashMap<>();
		
		for(int j=0,i=0;j<n;j++ ) {
			if(map.containsKey(s.charAt(j))) {
				i=Math.max(map.get(s.charAt(j)), i);
			}
			length=Math.max(length, (j-i)+1);
			map.put(s.charAt(j),j+1);
		}
		return length;
	}
}


// checking github
