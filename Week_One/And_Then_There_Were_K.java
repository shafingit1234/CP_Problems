package Week_One;

import java.util.Scanner;

public class And_Then_There_Were_K {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int start = 1;
		int end = n;
		int target = (int)(Math.log(end)/Math.log(2));
		int ans = 0;
		while(start <= end) {
			int mid = start + (end - start)/2;
			int temp = (int)(Math.log(mid)/Math.log(2));
			int diff = target - temp;
			if(diff > 1) {
				start = mid +1;
			}
			else if(diff <= 1) {
				ans = mid;
				end = mid-1;
			}
		}
		System.out.println(ans);
	}
	public static void findAnswerTwo() {
		int n= sc.nextInt();
		int target = (int)(Math.log(n)/Math.log(2));
		System.out.println((int)Math.pow(2, target)-1);
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
}
