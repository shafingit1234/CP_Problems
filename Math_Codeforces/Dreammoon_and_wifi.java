package Math_Codeforces;

import java.util.Scanner;

public class Dreammoon_and_wifi {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String a = sc.next();
		String b = sc.next();
		//find factorial
		int[] fact = new int[11];
		fact[0] = 1;
		for(int i=1 ; i<11; i++) {
			fact[i] = i*fact[i-1];
		}
		
		//a and b found
		int total_p = 0;
		int total_m = 0;
		int found_p = 0;
		int found_m = 0;
		for(int i=0 ; i<a.length(); i++) {
			if(a.charAt(i) == '+') {
				total_p++;
			}
			else if(a.charAt(i) == '-') {
				total_m++;
			}
			if(b.charAt(i) == '+') {
				found_p++;
			}
			else if(b.charAt(i) == '-') {
				found_m++;
			}
		}
		double prob = 1;
		if(found_m == total_m && found_p == total_p) {
			System.out.println(String.format("%.12f", prob));
			return ;
		}
		int remain_p = (total_p - found_p);
		int remain_m = (total_m - found_m);
		prob = 0;
		if(remain_p <0 || remain_m < 0) {
			System.out.println(String.format("%.12f", prob));
			return ;
		}
//		System.out.println(found_m + " "+found_p);
//		System.out.println(total_m + " "+total_p);
//		System.out.println(((fact[found_m])*(fact[found_p])));
		double no_of_arrangement = ((fact[remain_p + remain_m])/((fact[remain_m])*(fact[remain_p])));
//		System.out.println(no_of_arrangement);
		double total_ways = (1<<(remain_m + remain_p));
//		System.out.println(total_ways);
		double ans = no_of_arrangement/total_ways;
		System.out.println(String.format("%.12f", ans));
	}
}
