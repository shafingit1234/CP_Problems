package CP_problems;

import java.util.Scanner;

public class Vanya_and_fence {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		long n, m, i, j, h;
		n = sc.nextLong();
		h = sc.nextLong();
		i = 0;
		long ans1 = 0;
		long ans2 = 0;
		while(i < n) {
			m = sc.nextLong();
			if(m <= h) {
				ans1++;
			}
			else {
				ans2++;
			}
			i++;
		}
		//gjhbmbbmnb
		System.out.println(ans1 + ans2*2);
		return ;
	}
}
