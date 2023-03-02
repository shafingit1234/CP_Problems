package codeforces_contest_Div3_855;

import java.util.Scanner;

public class QuestionTwo {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int testcases =sc.nextInt();
		int i=0;
		while(i < testcases) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String str = sc.next();
			int[] lowerCase = new int[26];
			int[] upperCase = new int[26];
			for(int j=0 ;j<str.length(); j++) {
				if(str.charAt(j) >= 'a' && str.charAt(j) <= 'z') {
					lowerCase[str.charAt(j) - 97]++;
//					System.out.println(str.charAt(j) - 97);
				}
				else {
					upperCase[str.charAt(j) - 65]++;
//					System.out.println(str.charAt(j) - 65);
				}
			}
			int ans = 0;
			for(int j=0 ; j<26 ; j++) {
				if(lowerCase[j] == 0 && upperCase[j] == 0) {
					continue;
				}
				int mx = Math.max(lowerCase[j], upperCase[j]);
				int mn = Math.min(lowerCase[j], upperCase[j]);
				ans += mn;
				if(k == 0) {
					continue;
				}
				int remain = (mx - mn)/2;
				if(remain <= k) {
					k = k - remain;
					ans = ans + remain;
				}
				else{
					ans = ans+k;
					k = 0;
//					break;
				}
			}
			System.out.println(ans);
			i++;
		}
		
	}
}
