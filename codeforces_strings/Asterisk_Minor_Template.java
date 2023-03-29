package codeforces_strings;

import java.util.Scanner;

public class Asterisk_Minor_Template {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		String a = sc.next();
		String b = sc.next();
		if(a.charAt(0) == b.charAt(0)) {
			System.out.println("Yes");
            System.out.println(a.charAt(0)+"*");
            return;
		}
		if(a.charAt(a.length()-1) == b.charAt(b.length()-1)) {
			System.out.println("Yes");
            System.out.println("*" + a.charAt(a.length()-1));
            return;
		}
		
		for(int i=0 ; i<=a.length()-2 ; i++) {
			for(int j=0 ; j<=b.length()-2 ; j++) {
				if(a.charAt(i) == b.charAt(j) && a.charAt(i+1) == b.charAt(j+1)) {
					System.out.println("YES");
					System.out.println("*" + a.substring(i , i+2) + "*");
					return ;
				}
			}
		}
		char ans[] = LCS(a, b);
		if(ans.length == 1) {
			System.out.println("NO");
			return ;
		}
		StringBuilder sb = new StringBuilder("");
		for(int i=0 ; i<ans.length -1; i++) {
			if(i==0 && a.charAt(i) == ans[i]) {
				sb.append(ans[i]);
				sb.append("*");
			}
			else if(i == 0) {
				sb.append("*"); sb.append(ans[i]); sb.append("*");
			}
			else if(i == ans.length-1 && a.charAt(a.length()-1) == ans[i] && b.charAt(b.length()-1) == ans[i]){
//				sb.append("*");
				sb.append(ans[i]);
			}
			else if(i!=0) {
				sb.append(ans[i]);
				sb.append("*");
			}
		}
		int count = 0;
		for(int i=0 ; i<sb.length(); i++) {
			if(sb.charAt(i)=='*') count++; 
		}
		if(count >=(sb.length()+1)/2) {
			System.out.println("NO");
			return ;
		}
		System.out.println("YES");
		System.out.println(sb.toString());
		return ;
	}
	public static void main(String[] args) {
//		String a = sc.next();
//		String b = sc.next();
//		char ans[] = LCS(a , b);
//		for(int i=0 ; i<ans.length ; i++) {
//			System.out.print(ans[i]);
//		}
		int tc = sc.nextInt();
		while(tc > 0) {			
			findAnswer();
			tc--;
		}
	}
	public static char[] LCS(String a, String b)
	{
		int m = a.length();
		int n = b.length();
		int grid[][] = new int[m+1][n+1];
		for(int i=0 ; i<=a.length(); i++) {
			for(int j=0 ; j<=b.length(); j++) {
				if(i == 0 || j == 0) {
					grid[i][j] = 0;
					continue;
				}
				else if(a.charAt(i-1) == b.charAt(j-1)) {
					grid[i][j] = grid[i-1][j-1] + 1;
				}
				else {
					grid[i][j]= Math.max(grid[i-1][j], grid[i][j-1]);
				}
			}
		}
		int index = grid[m][n];
		char arr[] = new char[index + 1];
		arr[index] = '\u0000';
		int i=m;
		int j=n;
		while(i > 0 && j > 0) {
			if(a.charAt(i-1) == b.charAt(j-1)) {
				arr[index-1] = a.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else {
				if(grid[i-1][j] > grid[i][j-1]) {
					i--;
				}
				else {
					j--;
				}
			}
		}
		return arr;
		
	}
}
