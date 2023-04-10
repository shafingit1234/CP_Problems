package Week_One;

import java.util.ArrayList;
import java.util.Scanner;

public class K_divisors {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 1 ; i<=(n/2) ; i++) {
			if(n%i == 0) {
				al.add(i);
			}
		}
		al.add(n);
		for(int i : al) {
			System.out.println(i);
		}
//		System.out.println();
	}
	public static void main(String[] args) {
		findAnswer();
	}
}
