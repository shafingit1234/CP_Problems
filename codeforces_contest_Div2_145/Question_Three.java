package codeforces_contest_Div2_145;

import java.util.Scanner;

public class Question_Three {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc > 0) {
			int n  =sc.nextInt();
			int k  =sc.nextInt();
			int ans[] = new int[n];
			
			for(int i=0 ; i<n && k>0; i++) {
				if(k - (i+1) >= 0) {
					ans[i] = 31;
					k = k-(i+1);
				}
				else {
					ans[i] = -1*((i-k)*31 + 1);
					break;
				}
			}
			for(int i = 0 ;i < n; i++) {
				if(ans[i] == 0) {
					ans[i] = -1000;
				}
			}
//			System.out.println(ans);
			for(int i =0 ;i<n ;i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			tc--;
		}
	}
}
