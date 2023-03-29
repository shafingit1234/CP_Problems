package codeforces_strings;

import java.util.Scanner;

public class Distinct_Split {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int len = sc.nextInt();
		String a= sc.next();
		int freq_one[] = new int[26];
		int freq_two[] = new int[26];
		int set_one = 0;
		int set_two = 0;
		for(int i=0 ; i<a.length() ;i++) {
			freq_one[a.charAt(i) - 'a']++;
		}
		for(int i=0 ; i<=25 ; i++) {
			if(freq_one[i]>=1) {
				set_one++;
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i=0 ; i<a.length() ; i++) {
			freq_one[a.charAt(i)-'a']--;
			freq_two[a.charAt(i)-'a']++;
			if(freq_two[a.charAt(i)-'a'] == 1) {
				set_two++;
			}
			if(freq_one[a.charAt(i)-'a'] == 0) {
				set_one--;
			}
			int res = set_one + set_two;
			ans = Math.max(ans,  res);
		}
		System.out.println(ans);
		return ;
		
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc > 0) {
			findAnswer();
			tc--;
		}
	}
}
