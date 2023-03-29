package codeforces_strings;

import java.util.Scanner;

public class Infinite_Replacement {
	public static Scanner sc= new Scanner(System.in);
	public static void findAnswer() {
		long ans ;
		String s = sc.next();
		String t = sc.next();
		if(t.equals("a")) {
			ans = 1;
		}
		else if(t.contains("a")) {
			ans = -1;
		}
		else {
			int count = 0;
			for(int i=0 ; i<s.length();i++) {
				if(s.charAt(i) == 'a') {
					count++;
				}
			}
			ans = (long)Math.pow(2, count);
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc > 0) {
			findAnswer();
			tc--;
		}
	}
}
