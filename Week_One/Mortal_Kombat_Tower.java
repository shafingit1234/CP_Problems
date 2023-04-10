package Week_One;

import java.util.Scanner;

public class Mortal_Kombat_Tower {
	public static Scanner sc = new Scanner(System.in);
	public static Integer[][][] dp;
	public static int topDown(int[] boss, int secLast, int last, int ind) {
		if(ind >= boss.length) {
			return 0;
		}
		if(dp[secLast][last][ind] != null) {
			return dp[secLast][last][ind];
		}
		int ans = 0;
		if(secLast == 1 && last == 1) {
			dp[secLast][last][ind] = topDown(boss, 1, 0, ind+1);
			return dp[secLast][last][ind];
		}
		else if(secLast == 1 && last == 0) {
			int sp1 = topDown(boss, 0 , 1, ind+1);
			int sp2 = topDown(boss, 0, 0, ind+1);
			if(boss[ind] == 0) {
//				easy boss, handle by friend
				
				ans = Math.min(sp1, sp2);
			}
			else {
				ans = Math.min(1 + sp1 ,  sp2);
			}
		}
		else if(secLast == 0 && last == 1) {
			int sp1 = topDown(boss, 1 , 1, ind+1);
			int sp2 = topDown(boss, 1, 0, ind+1);
			if(boss[ind] == 0) {
//				easy boss, handle by friend
				
				ans = Math.min(sp1, sp2);
			}
			else {
				ans = Math.min(1 + sp1 ,  sp2);
			}
		}
		else if(secLast == 0 && last == 0) {
			int sp1 = topDown(boss, 0 , 1, ind+1);
//			int sp2 = topDown(boss, 0, 0, ind+1);
			if(boss[ind] == 0) {
//				easy boss, handle by friend
				
//				ans = Math.min(sp1, sp2);
				ans = sp1;
			}
			else {
//				ans = Math.min(1 + sp1 ,  sp2);
				ans = 1 + sp1;
			}
		}
		dp[secLast][last][ind] =  ans;
		return dp[secLast][last][ind];
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int boss[] = new int[n];
		for(int i=0; i<n  ; i++) {
			boss[i] = sc.nextInt();
		}
		dp = new Integer[2][2][n];
		int ans  = topDown(boss, 0 , 0 , 0);
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
