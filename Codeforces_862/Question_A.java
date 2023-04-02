package Codeforces_862;

import java.util.HashSet;
import java.util.Scanner;

public class Question_A {
	public static int findXor(int a, int b) {
		return a^b;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		boolean contains = true;
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i]=sc.nextInt();
			if(arr[i] == 0) {
				contains = false;
			}
		}
		int arr_b[] = new int[n];
		boolean check = true;
		for(int i=0 ; i<258 ; i++) {
			int ans = -1;
			for(int j=0 ; j<arr.length ;j++) {
				arr_b[j] = findXor(arr[j] , i);
				if(ans == -1) {
					ans = arr_b[j];
				}
				else {
					ans = findXor(ans, arr_b[j]);
				}
			}
			if(ans == 0) {
//				if(i == 0 && contains == false) {
//					continue;
//				}
				System.out.println(i);
				check = false;
				break;
			}
		}
		if(check == true) {
			System.out.println(-1);
		}
		return ;
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
