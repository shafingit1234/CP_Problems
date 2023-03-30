package CP_Practice;

import java.util.Scanner;

public class Vaccination {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int d = sc.nextInt();
		int w = sc.nextInt();
		int t[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			t[i] = sc.nextInt();
		}
		int init = t[0] + w;
		int covered = 1;
		int ans = 1;
		for(int i=1 ; i<n ; i++) {
			if(init >= t[i] - d && covered < k) {
				covered++;
			}
			else {
				ans++;
				covered = 0;
				init = t[i]+ w;
//				System.out.println(i);
				i--;
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int testcases = sc.nextInt();
		while(testcases-- > 0) {
			findAnswer();
		}
	}
}
