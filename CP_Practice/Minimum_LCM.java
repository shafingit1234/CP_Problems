package CP_Practice;

import java.util.Scanner;

public class Minimum_LCM {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		long n = sc.nextLong();
		boolean check = false;
		for(int i=2 ; i*i <= n ; i++) {
			if(n%i == 0) {
				long temp = n/i;
				System.out.println(temp + " " + (temp)*(i-1));
				check = true;
				break;
			}
		}
		if(check == false) {
			System.out.println(1 + " " + (n-1));
		}
		return ;
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
