package CP_Practice;

import java.util.Scanner;

public class Settlement_of_guinea_pigs {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int k = 0;
		int u = 0;
		int ans = 0;
		for(int i=0 ; i<n ; i++) {
			if(sc.nextInt() == 1) {
				u++;
			}
			else {
				k += u;
				u = 0;
			}
			int temp = 0;
			if(k != 0) {
				temp = k/2 + 1;
			}
			ans = Math.max(ans, u + temp);
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int tc  = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
