package CP_Practice;

import java.util.Scanner;

public class K_Divisible_Sum {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		long n = sc.nextLong();
		long k = sc.nextLong();
		long ele = (n-1)/k + 1;
		long sum = k*ele;
		System.out.println((sum + n - 1)/n);
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
