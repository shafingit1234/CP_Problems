package codeforces_contest_Div2_145;

import java.util.Scanner;

public class Question_Four {
	public static Scanner sc = new Scanner(System.in);
	public static long swap_cost = Long.parseLong("1000000000000");
	public static long del_cost=   Long.parseLong("1000000000001");
	public static void main(String[] args) {
//		int testcases = sc.nextInt();
//		while(testcases > 0) {
//			char[] s =sc.next().toCharArray();
//			int[] arr = new int[s.length];
//			for(int i=0 ; i<s.length; i++) {
//				arr[i] = s[i] - '0';
//			}
//			Long[][] dp = new Long[arr.length][4];
//			System.out.println(findAnswer(0, arr, 0, dp));
//			testcases--;
//		}
		int a = 456;
		int b ;
		int c;
		int d = 10;
		b = a/d;
		c = a-b;
//		System.out.println(a*b/c-d);
		System.out.println(c);
//		System.out.println(a*b/(c-d));
		
	}
	public static long findAnswer(int idx, int[] arr, int last,Long[][] dp) {
		if(idx >= arr.length) {
			return 0;
		}
		int state = 0;
		/* 
		 * possible combination to witness
		 * (idx)0 (last)0 let state = 0
		 * (idx)0 (last)1 let state = 1
		 * (idx)1 (last)0 let state = 2
		 * (idx)1 (last)1 let state = 3
		 * **/
		if(arr[idx] == 0 && last == 0) {
			state = 0;
		}
		else if(arr[idx] == 0 && last == 1) {
			state = 1;
		}
		else if(arr[idx] == 1 && last == 0) {
			state = 2;
		}
		else {
			state = 3;
		}
		if(dp[idx][state] != null) {
			return dp[idx][state];
		}
		//delete the current character.
		long ans = Long.MAX_VALUE;
		long sp1 = findAnswer(idx+1, arr, last , dp);
		if(sp1 < Long.MAX_VALUE)
			ans = Math.min(sp1+del_cost, ans);
		//swap 
		if(idx+1 < arr.length && arr[idx+1] >= last && arr[idx+1] < arr[idx]) {
			swap(arr, idx);
			long sp2 = findAnswer(idx+1, arr, arr[idx], dp);
			if(sp2 < Long.MAX_VALUE)
				ans = Math.min(sp2+swap_cost, ans);
			swap(arr, idx);
		}
		// do not do anything
		if(arr[idx] >= last) {
			long sp3 = findAnswer(idx+1, arr, arr[idx] , dp);
			if(sp3 < Long.MAX_VALUE)
				ans= Math.min(ans,  sp3);
		}
		dp[idx][state] = ans;
		return ans;
	}
	public static void swap(int[] arr, int i) {
		int temp = arr[i];
		arr[i] = arr[i+1];
		arr[i+1] = temp;
	}
}
