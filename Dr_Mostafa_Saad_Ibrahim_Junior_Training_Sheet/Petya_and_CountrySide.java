package Dr_Mostafa_Saad_Ibrahim_Junior_Training_Sheet;

import java.util.Scanner;

public class Petya_and_CountrySide {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] hts = new int[n];
		for(int i=0 ; i<n ; i++) {
			hts[i] = sc.nextInt();
		}
		int[] left = new int[n];
		int[] right=new int[n];
		left[0] = 0;
		int end = n-1;
		right[end] = end;
		int temp = 0;
		for(int i=1 ; i<n ; i++) {
			if(hts[i] < hts[i-1]) {
				temp = i;
				left[i]= i;
			}
			else {
				left[i] = temp;
			}
		}
		temp = end;
		for(int i=end -1; i>=0 ; i--) {
			if(hts[i] >= hts[i+1]) {
				right[i] = temp;
			}
			else {
				temp = i;
				right[i] = i;
			}
		}
		//find the answer;
		int ans = Integer.MIN_VALUE;
		for(int i=0 ; i<n;i++) {
			temp = Math.abs(left[i] - right[i]) + 1;
			ans = Math.max(ans,  temp);
		}
		System.out.println(ans);
	}
}
