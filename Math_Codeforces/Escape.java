package Math_Codeforces;

import java.util.Scanner;

public class Escape {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int vp = sc.nextInt();
		int vd = sc.nextInt();
		double t = sc.nextDouble();
		int f = sc.nextInt();
		double c = sc.nextDouble();
		int ans= 0;
		if(vd <= vp) {
			System.out.println(ans);
			return ;
		}
		while(c > 0) {
			double meet_point = (vp*t)/(vd - vp);
			double new_time = t + meet_point + f;
			double rem_dist = c - vp*(new_time);
			c = rem_dist;
//			System.out.println(rem_dist);
			if(c < 0) {
				break;
			}
			ans++;
			t = new_time;
			
		}
		System.out.println(ans);
//		1
//		2
//		1
//		1
//		8

	}
}
