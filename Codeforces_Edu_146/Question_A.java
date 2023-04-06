package Codeforces_Edu_146;

import java.util.Scanner;

public class Question_A {
	public static void findAnswer() {
		long n = sc.nextLong();
		long k = sc.nextLong();
		if(n%2 == 0) {
			System.out.println("YES");
		}
		else if(n%2!=0) {
			if(k%2 != 0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
