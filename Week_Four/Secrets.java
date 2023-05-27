package Week_Four;

import java.util.Scanner;

public class Secrets {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = 1;
		while(tc-- > 0) {
			long n = sc.nextLong();
			if(n%3 == 0) {
//				System.out.println(1);
				long x = 3;
				while(n%x == 0) {
					x *= 3;
				}
				System.out.println(((n/x) + 1));
			}
			else {
				System.out.println((n+2)/3);
			}
		}
	}
}
