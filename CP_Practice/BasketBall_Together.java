package CP_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class BasketBall_Together {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int d = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length-1;
		int sum = 0;
		int ans = 0;
		// 1 2 2 3 3 7 8 9
		while(start < end) {
			sum += arr[end];
			if(sum > d) {
				ans++;
				sum = 0;
				end--;
			}
			while(start < end) {
				sum = sum + arr[end];
				
				start++;
				if(sum > d) {
					ans++;
					break;
				}
			}
			if(start == end) {
				break;
			}
			sum = 0;
			end--;
		}
		System.out.println(ans);
	}
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		int d = sc.nextInt();
		long arr[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		int end = arr.length-1;
		int ele_covered = 0;
		int ans = 0;
		for(int i=end ; i>=0;i--) {
			long x = d/arr[i];
			ele_covered+=x;
			if(ele_covered > i) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
//		int tc = sc.nextInt();
		int tc =1;
		while(tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
}
