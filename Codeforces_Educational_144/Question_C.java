package Codeforces_Educational_144;

import java.util.Scanner;

public class Question_C {
	public static double log2(int x) {
		return Math.log(x) / Math.log(2);
	}
	public static int mod = 998244353;
	public static void findAnswer() {
		int left = sc.nextInt();
		int right= sc.nextInt();
		long ans = 0;
		int pow_of_two = left;
		int ele = 0;
		int mul = 1;
		while(pow_of_two <= right) {
			pow_of_two *= 2;
			mul*=2;
			ele++;
		}
		mul /= 2;
		int ind_one = bs_one(left, right, mul);
		mul /= 2;
		int ind_two  = bs_one(left, right, (mul)*3);
		ans += (ind_one - left + 1);
		ans += (ind_two - left + 1)*(ele-1);
		ans = ans%mod;
		System.out.println(ele + " " + ans);
	}
	public static int bs_one(int l, int r, int k) {
		int start = l;
		int end = r;
		int ans = start-1;
		while(start <=end) {
			int mid = start + (end - start)/2;
			if(1L*mid*k <= r) {
				ans = mid;
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return ans;
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
