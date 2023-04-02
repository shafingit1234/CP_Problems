package Codeforces_862;

import java.util.Scanner;

public class Question_B {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		String str = sc.next();
		int min_idx = -1;
		char min_char = 'z';
		boolean check = true;
		for(int i=str.length()-1; i>=0 ; i--) {
			if(check == true) {
				if(str.charAt(i) == min_char) {
					min_idx = i;
					check = false;
					continue;
				}
			}
			if(str.charAt(i) < min_char) {
				min_char = str.charAt(i);
				min_idx= i;
				check = false;
			}
		}
		StringBuilder sb = new StringBuilder("");
		sb.append(str.charAt(min_idx));
		for(int i=0 ; i<str.length() ; i++) {
			if(i == min_idx) {
				continue;
			}
			sb.append(str.charAt(i));
		}
//		return sb.toString();
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
