package CP_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Going_To_The_Cinema {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswerOptimal() {
		int n= sc.nextInt();
		int arr[] = new int[n];
		
		int freq[] = new int[n+1];
		for(int i=0 ; i<n; i++) {
			int a = sc.nextInt();
			
			freq[a]++;
		}
		int sum = 0;
		int ans = 0;
		for(int valid_set_size = 0 ; valid_set_size<= n; valid_set_size++) {
			if(freq[valid_set_size] == 0 && sum == valid_set_size) {
				ans++;
			}
			sum += freq[valid_set_size];
//			System.out.println(valid_set_size);
		}
		System.out.println(ans);
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i= 0 ;i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
//		boolean visited[] = new boolean[n];
		int ans = 0;
//		for(int i=0 ; i<n ; i++) {
//			if(i >= arr[i]) {
//				visited[i] = true;
//			}
//		}
		for(int i=0 ; i<n ; i++) {
//			if(visited[i] == true) {
//				if(i == 0) {
//					ans++;
//				}
//				else if(visited[i-1] == false) {
//					ans++;
//				}
//			}
			if(i >= arr[i]) {
				if(i == 0) {
					ans++;
				}
				else if(i-1 < arr[i-1]) {
					ans++;
				}
			}
		}
		if(arr[0] > 0) {
			ans++;
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int tc =sc.nextInt();
		while(tc-- > 0) {
//			findAnswer();
			findAnswerOptimal();
		}
	}
}
