package Codeforces_Educational_144;

import java.util.Scanner;

public class Question_A {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		String s = sc.next();
		
		String str = "FBFFBFFBFBFFBFFBFBFFBFFB";
		if(str.contains(s) == true) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
