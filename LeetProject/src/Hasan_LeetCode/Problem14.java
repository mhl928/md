package Hasan_LeetCode;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
public class Problem14 {
	
	public static void main(String[] args){
		String[] sArr={"leets", "leetcode", "leet", "leetes"};
		String cPrefix=longestCommonPrefix(sArr);
		System.out.println("Longest common prefix: "+cPrefix);
	}
	
	public static String longestCommonPrefix(String[] sArr){
		if(sArr.length==0) return "";
		String commonPrefix=sArr[0]; // consider the first word of the array is prefix
		for(int i=1;i<sArr.length;i++){
			// check every other word of the the array with the prefix
			// if the prefix contains in the word then it is 0 otherwise -1
			//if -1 then prefix letter drop down 1 and we will get new prefix
			while(sArr[i].indexOf(commonPrefix)!=0){ 
				commonPrefix=commonPrefix.substring(0,commonPrefix.length()-1);
				if(commonPrefix.isEmpty()) return "";
			}
			
		}
		return commonPrefix;
	}

}
