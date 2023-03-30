package CP_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Monsters {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		long ans = 0;
		int k = 1;
		for(int i=0 ; i<n ; i++) {
			if(arr[i] == k) {
				k++;
			}
			else if(arr[i] >k) {
				ans += arr[i] - k;
				k++;
			}
		}
		System.out.println(ans);
		
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
