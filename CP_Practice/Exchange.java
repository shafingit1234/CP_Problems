package CP_Practice;

import java.util.Scanner;

public class Exchange {
	public static Scanner sc = new Scanner(System.in); 
	public static void findAnswer() {
		long need = sc.nextLong();
		long a = sc.nextLong();
		long b =sc.nextLong();
		if(a >b) {
			System.out.println("1");
			return ;
		}
//		long temp = (need - a + 1)/a;
//		long temp = (long)Math.ceil((need  + 1)/ a);
		long temp = ((need + a - 1)/a);
				
		System.out.println(temp);
		return ;
	}
	
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
