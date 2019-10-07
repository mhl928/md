package md.Hello;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Welcome to Hello world!!! and math!!!");
		int[] arr= {2,4,2,4,2,6,7,10};
		int sum=sumArray(arr);
		System.out.println("Sum of the arry is = "+sum);
	}
	
	public static int sumArray(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
		 sum+=arr[i];
		}
		return sum;
	}
	
	
	
}