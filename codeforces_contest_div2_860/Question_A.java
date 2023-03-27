package codeforces_contest_div2_860;

import java.util.Scanner;

public class Question_A {
	public static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		while(testcase>0) {
			int len = sc.nextInt();
			int a[] = new int[len];
			int b[] = new int[len];
			int mx1 = Integer.MIN_VALUE;
			int mx2 = Integer.MIN_VALUE;
			for(int i=0 ;i<len-1 ;i++) {
				a[i] = sc.nextInt();
				mx1 = Math.max(mx1,  a[i]);
			}
			a[len-1] = sc.nextInt();
			for(int i=0; i<len-1 ; i++) {
				b[i] = sc.nextInt();
				mx2 = Math.max(mx2,  b[i]);
			}
			b[len-1] = sc.nextInt();
			mx1 = Integer.MIN_VALUE;
			mx2 = Integer.MIN_VALUE;
			for(int i=0 ;i < a.length ; i++) {
				if(a[i] < b[i]) {
					int temp = a[i];
					a[i] = b[i];
					b[i] =temp;
				}
				mx1 = Math.max(mx1, a[i]);
				mx2 = Math.max(mx2, b[i]);
			}
//			System.out.println(mx1 + " " + mx2);
//			System.out.println(b[len-1] + " " + a[len-1]);
			if(a[len-1] == mx1 && b[len-1] == mx2) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
//			System.out.println(mx1 + " " + mx2);
//			System.out.println(b[len-1] + " " + a[len-1]);
//			if(b[len-1] >= mx1 && a[len-1] >= mx2) {
//				System.out.println("YES");
//			}
//			else {
//				System.out.println("NO");
//			}
			testcase--;
			/*
			 * 9
1 2 3 4 5 6 7 8 9
9 9 9 9 9 9 6 6 6
			 * */
		}
	}
}
