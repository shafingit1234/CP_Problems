package CP_Practice;

import java.util.Scanner;

public class Koxia_Permutation {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int k =sc.nextInt();
		int p = 0;
		while(n-1 > 2*p) {
			System.out.print((n-p) + " ");
			System.out.print((p+1) + " ");
			p++;
		}
		if(n%2 != 0) {
			System.out.print((p+1) + " ");
		}
		System.out.println();
		return ;
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
