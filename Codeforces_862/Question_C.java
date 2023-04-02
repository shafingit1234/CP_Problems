package Codeforces_862;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
		if(c == 0) {
			return false;
		}
		long temp= (b - k)*(b - k);
		long D= temp - 4*a*c;
		if(D >= 0) {
			return false;
		}
		return true;
	}
	public static boolean check_2(long k, long a, long b, long c) {
		long ans = (long)Math.ceil(b - Math.sqrt(4*a*c));
		if(a*c > 0 && ans < k) {
//			System.out.println(b - Math.sqrt(4*a*c));
			return true;
		}
		return false;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		long arr_k[] = new long[n];
		ArrayList<pair> al = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			arr_k[i] = sc.nextLong();
		}
		Arrays.sort(arr_k);
		for(int i=0 ; i<m ; i++) {
//			al.add(new pair(sc.nextInt() , sc.nextInt() , sc.nextInt()));
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			if(c <= 0) {
				System.out.println("NO");
				continue;
			}
			int start = 0;
			int end = arr_k.length-1;
			int ans = -1;
			while(start <= end) {
				int mid = start + (end- start)/2;
				if(check(arr_k[mid], a , b , c) == true) {
					ans= mid;
//					break;
//					start = mid+1;
					end = mid-1;
					break;
				}
				else {
//					end = mid-1;
					start = mid+1;
				}
			}
			if(ans == -1) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
				System.out.println(arr_k[ans]);
			}
		}
		
	}
	public static void findAnswer_two() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		long arr_k[] = new long[n];
		ArrayList<pair> al = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			arr_k[i] = sc.nextLong();
		}
//		Arrays.sort(arr_k);
		for(int i=0 ; i<m  ; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			if(c <= 0) {
				System.out.println("NO");
				continue;
			}
			double temp_one = -b/(2.0*a);
			double temp_two = a*temp_one*temp_one + b*temp_one + c;
			boolean check = false;
			for(int j=0 ; j<n ; j++) {
				if(temp_two > arr_k[j]*temp_one) {
					System.out.println("YES");
					System.out.println(arr_k[j]+1);
					check = true;
					break;
			
				}
				else if(temp_two < arr_k[j]*temp_one) {
					System.out.println("YES");
					System.out.println(arr_k[j]-1);
//					System.out.println();
					check  = true;
					break;
				}
			}
			if(check == false) {
				System.out.println("NO");
			}
		}
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
//			findAnswer();
			findAnswer_two();
		}
	}
}
