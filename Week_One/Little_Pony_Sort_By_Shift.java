package Week_One;

import java.util.Scanner;

public class Little_Pony_Sort_By_Shift {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int[] arr = new int[n];
		int count =0;
		int ind = 0;
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
			if(i > 0 && arr[i-1] > arr[i]) {
				count++;
				ind = i;
			}
		}
//		System.out.println(count);
		if(count == 0) {
			System.out.println(0);
			return ;
		}
		else if(count == 1){
//			System.out.println(-1);
			if(arr[n-1] <= arr[0]) {
				System.out.println(n - ind);
				return ;
			}
//			return ;
		}
		System.out.println(-1);
		return ;
	}
	public static void main(String[] args) {
		findAnswer();
	}
}
