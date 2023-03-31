package CP_Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Traffic_Light {
	public static Scanner sc  = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		char ch = sc.next().charAt(0);
//		System.out.println(n + " " + ch);
		char arr[] = sc.next().toCharArray();
		int start = 0;
		int end = n;
		if(arr.length == 1 || ch == 'g') {
			System.out.println("0");
			return ;
		}
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		int id = ch - 'a';
		int green = 'g' - 'a';
		hm.put(id , new ArrayList<Integer>());
		hm.put(green, new ArrayList<Integer>());
		for(int i=0 ; i<arr.length; i++) {
//			System.out.print(arr[i] - 'a' + " ");
			if(arr[i] == ch) {
				hm.get(id).add(i);
			}
			if(arr[i] == 'g') {
				hm.get(green).add(i);
			}
		}
//		System.out.println();
//		for(int i:hm.get(ch - 'a')) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		for(int j : hm.get('g' - 'a')) {
//			System.out.print(j + " ");
//		}
//		System.out.println();
		int res = Integer.MIN_VALUE;
		//find nearest g index for r.
		for(int i : hm.get(ch - 'a')) {
			int ans = Integer.MAX_VALUE;
			for(int j : hm.get('g' - 'a')) {
				if(i < j) {
					ans= Math.min(ans, (j-i));
//					break;
				}
				else if(i > j) {
					ans = Math.min(ans, (n-i) + j);
				}
//				System.out.println(ans);
			}
			res = Math.max(res,  ans);
		}
		if(res == Integer.MAX_VALUE || res == Integer.MIN_VALUE) {
			res = 0;
		}
		System.out.println(res);
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
