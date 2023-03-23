package Math_Codeforces;

import java.util.Scanner;

public class Restoring_Painting {
	public static Scanner sc = new Scanner(System.in);
	public static boolean check(long a , long n) {
		if(a >= 1 && a <= n) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		long n = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = sc.nextLong();
		long k2 = c - b;
		long k1 = d - a;
		long ans = 0;
		for(long f = 1 ; f <= n ; f++) {
			long z= k2 + f;
			long e =k1 + f;
			long y= e + z - f;
			if(check(z , n) && check(e , n) && check(y , n)) {
				ans++;
			}
			
		}
		System.out.println(ans*n);
		//multiplying with n, because with center there is no constraint,
		// if my answer tuple is (1,2,3) => (z,y,e) for some value of f, then x can have value between
		// 1 to n, making answers => {(1,2,3,1) , {1,2,3,2} , ...} total n answers, for some value of f.
	}
}
