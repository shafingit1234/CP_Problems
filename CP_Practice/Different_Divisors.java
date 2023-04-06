//package CP_Practice;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Different_Divisors {
//	public static Scanner sc = new Scanner(System.in);
//	public static void findAnswer() {
//		int d = sc.nextInt();
////		find primes
//		boolean prime[] = new boolean[d+10000];
//		Arrays.fill(prime, true);
//		prime[0] = false;
//		prime[1] = false;
//		for(int i=2 ;i*i<prime.length ; i++) {
//			if(prime[i] == false) continue;
//			else {
//				for(int j = i+i ; j<prime.length ; j+=i) {
//					prime[i] = false;
//				}
//			}
//		}
//		//find divisors.
//		for(int i=2 ; i<prime.length ; i++) {
//			if(prime[i] == true) {
//				if()
//			}
//		}
//	}
//	public static void main(String[] args) {
//		int tc = sc.nextInt();
//		while(tc-- > 0) {
//			findAnswer();
//		}
//	}
//}
