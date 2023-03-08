package Math_Codeforces;

import java.util.Scanner;

public class BowWow_and_TimeTable {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
//		long num = sc.nextLong();
		String str = sc.next();
		int len = str.length();
		int idx = str.substring(1,len).lastIndexOf('1');
		int cnt = 0;
		if(idx != -1 && idx != len) {
			cnt = 1;
		}
		System.out.println((((len + cnt)/2)));
	}
}
