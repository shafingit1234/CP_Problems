package CP_Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Different_Differences {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int k = sc.nextInt();
		int n = sc.nextInt();
//		
		ArrayList<Integer> al= new ArrayList<>();
		int diff=1;
		int val = 1;
		for(int i=0 ; i<k ; i++) {
			System.out.print(val + " ");
			if(i == k) {
				continue;
			}
//			diff++;
			if((val + diff -i - 1) <= (n-k+1)) {
				val = val+diff;
				diff++;
			}
			else {
				val = val + 1;
			}
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
