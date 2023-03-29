package codeforces_strings;

import java.util.Scanner;

public class Double_ended_strings {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		String a = sc.next();
		String b = sc.next();
		if(a.length() < b.length()) {
			String temp = b;
			b = a;
			a = temp;
		}
		int m = a.length();
		int n = b.length();
		for(int len = m ; len > 0 ; len--) {
			for(int i = len ; i<= n; i++) {
				String chk = b.substring(i-len , i);
//				if(a.indexOf(chk) == -1)
				int idx = a.indexOf(chk);
				if(idx !=-1) {
					System.out.println((n+m) - 2*(chk.length()));
					return ;
				}
			}
		}
		System.out.println(n+m);
	}
	public static void main(String[] args) {
		int tc  =sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
