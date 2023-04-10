package Week_One;

import java.util.HashSet;
import java.util.Scanner;

public class Good_Substrings {
	public static Scanner sc = new Scanner(System.in);
	public static HashSet<String> hs = new HashSet<String>();
	public static void findAnswer() {
		String n= sc.next();
		int[] val = new int[26];
//		String t =sc.findInLine(;)
		String t  =sc.next();
		for(int i=0 ; i<26 ; i++) {
//			val[i] = sc.next();
			val[i] = t.charAt(i) - '0';
//			System.out.println(val[i]);
		}
		int k = sc.nextInt();
		for(int i=0 ; i< n.length() ; i++) {
//			find all valid substrings
//			String first = 
			for(int j=i+1 ; j<n.length() ; j++) {
				String temp = n.substring(i , j);
//				hs.add(temp);
				if(valid(val, temp , k) == true) {
					hs.add(temp);
				}
			}
		}
		
//		System.out.println();
		System.out.println(hs.size());
		for(String s : hs) {
			System.out.print(s + " ");
		}

		hs.clear();
		
	}
	public static long mod = 1000000009;
	public static void findAnswerTwo() {
		String str = sc.next();
		String val = sc.next();
		int k = sc.nextInt();
		int hash[] = new int[26];
		for(int i=0 ; i<26 ; i++) {
			hash[i] = (val.charAt(i) - '0');
		}
		int ans = 0;
		HashSet<Long> newH = new HashSet<Long>();
		for(int i=0 ; i<str.length() ; i++) {
			int count = 0;
			long sum = 0;
			long mul = 1;
			for(int j =i ; j<str.length() ; j++) {
				int idx = str.charAt(j) - 'a';
				count +=(1 - hash[idx]);
				idx++;
				sum += (mul*idx);
				if(count <= k) {
//					hs.add(str.substring(i , j + 1));
//					System.out.println(sum + " " + str.substring(i , j+1));
					newH.add(sum);
					mul = (mul*31);
				}
				else {
					break;
				}
			}
		}
		System.out.println(newH.size());
//		System.out.println(hs.size());
		hs.clear();
	}
	public static boolean valid(int []val, String temp , int k) {
		int count = 0;
		for(int i=0 ; i<temp.length(); i++) {
			if(val[temp.charAt(i)-'a'] == 0) {
				count++;
			}
		}
		if(count > k) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
//		findAnswer();
		findAnswerTwo();
	}
}
