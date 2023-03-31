package CP_Practice;

import java.util.Scanner;

public class Challenging_Valley {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		int start = 0;
		int end = 0;
		int count = 0;
		while(end < n) {
			
			while(end < n && arr[start] == arr[end]) {
				end++;
			}
			if(end == n) {
				if(start==0) {
					count++;
					break;
				}
				if(start < n && arr[start-1] > arr[start]) {
					count++;
				}
				break;
			}
			if(start == 0) {
				if(end < n && arr[end] > arr[start]) {
					count++;
				}
			}
			else {
				if(start < n && end < n && arr[start-1] > arr[start] && arr[end-1] < arr[end]) {
					count++;
				}
			}
			if(count > 1) {
				System.out.println("NO");
				return ;
			}
//			System.out.println(start + " " + end);
//			System.out.println(count);
			
			start = end;
		}
//		System.out.println(count);
		if(count == 1) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
//		System.out.println("YES");
		
		return ;
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
