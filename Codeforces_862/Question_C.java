package Codeforces_862;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Question_C {
	public static Scanner sc = new Scanner(System.in);
	public static class pair{
		int a;
		int b;
		int c;
		pair(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	public static boolean check(long k, long a, long b, long c) {
		
		long temp= (b - k)*(b - k);
		long D= temp - 4*a*c;
		if(D < 0) {
			return true;
		}
		return false;
	}
	public static boolean check_2(long k, long a, long b, long c) {
		double sqrt_one = Math.sqrt(4*a*c);
		long left = (long) Math.floor((b - k) - sqrt_one);
		long right= (long) Math.floor((b-k) + sqrt_one);
		if(left >= 0 && right >= 0) {
			return false;
		}
		return true;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int m = sc.nextInt();
//		long arr_k[] = new long[n];
		TreeSet<Long> ts = new TreeSet<Long>();
//		ArrayList<pair> al = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
//			arr_k[i] = sc.nextLong();
			ts.add(sc.nextLong());
		}
//		Arrays.sort(arr_k);
		for(int i=0 ; i<m ; i++) {
//			al.add(new pair(sc.nextInt() , sc.nextInt() , sc.nextInt()));
			long a = sc.nextInt();
			long b = sc.nextInt();
			long c = sc.nextInt();
			if(c <= 0) {
				System.out.println("NO");
				continue;
			}
//			int start = 0;
//			int end = arr_k.length-1;
//			int ans = -1;
//			while(start <= end) {
//				int mid = start + (end- start)/2;
//				if(check(arr_k[mid], a , b , c) == true) {
//					ans= mid;
////					break;
////					start = mid+1;
//					end = mid-1;
//					break;
//				}
//				else {
////					end = mid-1;
//					start = mid+1;
//				}
//			}
//			if(ans == -1) {
//				System.out.println("NO");
//			}
//			else {
//				System.out.println("YES");
//				System.out.println(arr_k[ans]);
//			}
			Long k = ts.floor(b);
			if(k!=null && (b-k)*(b-k) < 4*a*c) {
				System.out.println("YES");
				System.out.println(k);
				continue;
			}
			k = ts.ceiling(b);
			if(k!= null && (b-k)*(b-k)<4*a*c) {
				System.out.println("YES");
				System.out.println(k);
				continue;
			}
			System.out.println("NO");
		}
		
	}
	
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
//			findAnswer_two();
		}
	}
}
