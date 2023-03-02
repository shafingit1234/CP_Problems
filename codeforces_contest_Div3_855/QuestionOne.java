package codeforces_contest_Div3_855;

import java.util.Scanner;

public class QuestionOne {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int testcases =sc.nextInt();
		int i=0;
		char arr[] = new char[4];
		arr[0] = 'm';
		arr[1] = 'e';
		arr[2] = 'o';
		arr[3] = 'w';
		int p=0;
		while(i < testcases) {
			int len = sc.nextInt();
			String str = sc.next();
			if(str.length() < 4) {
				System.out.println("NO");
				i++;
				continue;
			}
			p= 0;
			str = str.toLowerCase();
//			System.out.println(str);
			int j=0;
			boolean flag= false;
			
			while(j < str.length()){
				if(str.charAt(j) != arr[p]) {
//					System.out.println(arr[p] + " " + str.charAt(j));
					System.out.println("NO");
					break;
				}
				while(j<str.length() && str.charAt(j)== arr[p]) {
					flag = true;
					j++;
				}
				p++;
				if(flag == false) {
					j++;
				}
				flag = false;
				if(p >= 4 ) {
					break;
				}
			}
			if(p>=4 && j>=str.length()) {
				System.out.println("YES");
			}
			else if(p>=4) {
				System.out.println("NO");
			}
			i++;
		}
	}
}
