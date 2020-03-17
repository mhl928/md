package Hasan_LeetCode;
/*
 *Wildcard Matching:
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
 */
public class Problem44 {     // video link: https://www.youtube.com/watch?v=3ZDZ-N0EPV0
	
	public static void main(String[] args) {
		String s="hewihfiowehf";
		String p="*???*?*****f";
		boolean bo=isMatched(s,p);
		System.out.println("\n Is pattern matched? "+bo);
	}
	
	public static boolean isMatched(String s, String p) {
		char[] str = s.toCharArray();
		char[]pattern=p.toCharArray();
		int patternIndex=0;
		boolean isFirst=true;
		
		// to make a***b*c****d->a*b*c*d
		for(int i=0;i<pattern.length;i++) {
			if(pattern[i]=='*') {
				if(isFirst) {
					pattern[patternIndex++]=pattern[i];
					isFirst=false;
				}
			}
			else {
				pattern[patternIndex++]=pattern[i];
				isFirst=true;
			}
		}
		
		// print the new pattern 
		/*for(int i=0;i<patternIndex;i++) {
			System.out.print(pattern[i]);
		}*/
		boolean T[][]= new boolean[str.length+1][patternIndex+1];
		
		if(patternIndex>0 && pattern[0]=='*') {
			T[0][1]=true;
		}
		T[0][0]=true;
		
		for(int i=1;i<T.length;i++) {
			for(int j=1;j<T[0].length;j++) {
				if(pattern[j-1]=='?'||str[i-1]==pattern[j-1]) {
					T[i][j]=T[i-1][j-1];
				}
				else if(pattern[j-1]=='*') {
					T[i][j]=T[i-1][j] || T[i][j-1];
				}
			}
		}
		return T[str.length][patternIndex];
	}

}
