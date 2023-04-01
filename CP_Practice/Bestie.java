package CP_Practice;

import java.util.Scanner;

public class Bestie {
	public static Scanner sc = new Scanner(System.in);
//	public static long gcd_my(long a, long b) {
//		if(a == 1 || b == 1) return 1;
//		if(a == b) return a;
//		if(a > b) return gcd(a - b , b);
//		return gcd(a , b-a);
//	}
//	public static long gcd(long a, long b)
//	{
//	    while (a > 0 && b > 0) {
//	        if (a > b) {
//	            a = a % b;
//	        }
//	        else {
//	            b = b % a;
//	        }
//	    }
//	    if (a == 0) {
//	        return b;
//	    }
//	    return a;
//	}
	static int gcd(int a, int b){
        if(b==0) return a;
 
        return gcd(b, a%b);
    }
	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		int ans = 0;
		int res = -1;
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == 1) {
//				System.out.println(0);
				res = 0;
//				return ;
			}
			if(res == 0) {
				continue;
			}
			if(i == 0) ans = arr[i];
			else {
				ans = gcd(ans, arr[i]);
			}
			if(ans == 1) {
				res = 0;
			}
		}
		if(res == 0) {
			System.out.println(res);
			return ;
		}
//		long operation = 0;
		res = 0;
//		System.out.println(ans);
//		int cost = -1;
//		for(int i=arr.length-1 ; i>=0 ; i--) {
//			int temp = gcd(i+1, arr[i]);
//			if(temp >= ans && temp%ans == 0) {
//				continue;
//			}
//			if(temp > ans && temp%ans != 0) {
//				res += (arr.length - i);
//				int temp_two = ans;
//				ans = gcd(temp , ans);
//				if(ans == 1) {
////					break;
//					cost = Math.min(cost, res);
//				}
//			}
//			else if(temp < ans){
//				res += (arr.length-i);
//				int temp_two = ans;
//				ans = gcd(temp, ans);
//				if(ans == 1) break;
//			}
//		}
//		System.out.println(Math.min(3, res));
		int cost = n;
		for(int i=n ; i>=1 ; i--) {
			int temp = gcd(arr[i-1] , i);
			if(gcd(temp, ans) == 1) {
				cost = Math.min(3, n-i+1);
				break;
			}
		}
		System.out.println(cost);
		
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
