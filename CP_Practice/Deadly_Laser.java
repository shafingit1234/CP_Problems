package CP_Practice;

import java.util.Scanner;

public class Deadly_Laser {
	public static void findAnswer() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		int d = sc.nextInt();
		int steps = n + m - 2;
		if((n - sx) > d && (sy - 1) > d) {
			System.out.println(steps);
			return ;
		}
		if((m - sy) > d && (sx - 1) > d) {
			System.out.println(steps);
			return ;
		}
		System.out.println(-1);
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
