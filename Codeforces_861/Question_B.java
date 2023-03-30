package Codeforces_861;

import java.util.ArrayList;
import java.util.Scanner;

public class Question_B {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc= sc.nextInt();
		while(tc-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int i=0;
			ArrayList<ArrayList<Integer>> al = new ArrayList<>();
			ArrayList<ArrayList<Integer>> diff = new ArrayList<>();
			while(i<n) {
				
				al.add(new ArrayList<>());
				for(int j=0 ; j<m ; j++) {
					al.get(i).add(sc.nextInt());
				}
				i++;
			}
			for(i=0 ; i<m ; i++) {
				int mx = Integer.MIN_VALUE;
				int mn = Integer.MAX_VALUE;
				for(int j=0 ;j<n ; j++) {
					mx = Math.max(mx, al.get(j).get(i));
					mn = Math.min(al.get(j).get(i), mn);
				}
				int temp = Math.abs(mx - mn);
				
			}
		}
	}
}
