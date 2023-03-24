package codeforces_contest_Div2_145;

import java.util.ArrayList;
import java.util.Scanner;

public class Question_Two {
	public static Scanner sc = new Scanner(System.in);
	public static void bin1(long n) {
		long l = 0;
		long r = (long)1e9;
		long ans = 0;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (mid * mid <= n) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(ans);
	}
	public static void findAnswer() {
		long n = sc.nextLong();
		if(n == 0 || n == 1) {
			System.out.println(0);
			return ;
		}
		bin1(n-1);
		
//		System.out.println((long)Math.sqrt(n-1));
//		long ans = (long)Math.sqrt(n);
//		if(ans*ans == n) {
//			System.out.println(ans-1);
//			return ;
//		}
//		System.out.println(ans);
		
	}
	public static void main(String[] args) {
		int testcases = sc.nextInt();
		while(testcases > 0) {
			findAnswer();
			testcases--;
		}
	}
}
