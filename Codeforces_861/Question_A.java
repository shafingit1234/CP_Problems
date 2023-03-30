package Codeforces_861;

import java.util.Scanner;

public class Question_A {
	public static Scanner sc = new Scanner(System.in);
	public static int findLuckyNumber(int a) {
		int mn = 10;
		int mx = -1;
		while(a>0) {
			mn = Math.min(a%10, mn);
			mx = Math.max(a%10, mx);
			a = a/10;
		}
		return mx - mn;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		while(testcase-- > 0) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			int i=0;
			int result = -1;
			int num = 0;
			while(i <= 100 && num1 <= num2) {
				int ans = findLuckyNumber(num2);
				if(result < ans) {
					num = num2;
				}
				result = Math.max(result,ans);
				num2--;
				i++;
			}
			System.out.println(num);
			
		}
	}
}
