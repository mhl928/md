package Hasan_LeetCode;

import java.util.HashMap;

public class Problem13 {

	public static void main(String[] args){
		String x="MMMMDLXXXIX";
		int roman=numToRoman(x);
		System.out.println("Integer of "+x+" = "+roman);
		
	}
	
	
	public static int numToRoman(String x){
		int num=0;
		HashMap<Character,Integer> map= new HashMap<Character,Integer>();
		map.put('M',1000);
		map.put('D',500);
		map.put('C',100);
		map.put('L',50);
		map.put('X',10);
		map.put('V',5);
		map.put('I',1);
		
		for(int i=0;i<x.length();i++){
			
			if(i>0 && map.get(x.charAt(i))>map.get(x.charAt(i-1))){ // for CM=900, CD=400, XC=90,XL=40 etc
				num=num+map.get(x.charAt(i))-2*map.get(x.charAt(i-1));
			}
			else{
			num=num+map.get(x.charAt(i));
			}
		}
		
		return num;
	}
	
}
