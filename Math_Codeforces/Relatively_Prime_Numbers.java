package Math_Codeforces;

import java.util.Scanner;

public class Relatively_Prime_Numbers {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		long l = sc.nextLong();
		long r = sc.nextLong();
		if(l>=r) {
			System.out.println("NO");
			return ;
		}
		System.out.println("YES");
		while(l < r) {
			System.out.println(l + " " + (l+1));
			l+=2;
		}
		return ;
	}
}
