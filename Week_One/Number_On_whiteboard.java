package Week_One;

import java.util.Scanner;

public class Number_On_whiteboard {
	public static void findAnswer() {
		int num = sc.nextInt();
		int i = num-1;
		int j = num;
		System.out.println(2);
		while(i > 0) {
			System.out.println(j + " " + i);
			j = (j + i + 1)/2;
			i--;
		}
	}
	public static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
