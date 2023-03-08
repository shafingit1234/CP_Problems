package Math_Codeforces;

import java.util.Scanner;

public class Balanced_rating_change {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int num = sc.nextInt();
		int[] arr = new int[num];
		boolean flag = false;
		for(int i=0 ; i<num ; i++) {
			arr[i] = sc.nextInt();
			double k = ((double)arr[i])/2;
			if(arr[i]%2 != 0) {
				if(flag == false) {
					flag = !flag;
					arr[i] = (int) Math.ceil(k);
					
				}
				else if(flag) {
					flag= !flag;
					arr[i] = (int)Math.floor(k);
				}
			}
			else {
				arr[i] = arr[i]/2;
			}
			System.out.println(arr[i]);
		}
	}
}
