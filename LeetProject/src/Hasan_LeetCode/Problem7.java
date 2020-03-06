package Hasan_LeetCode;




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
