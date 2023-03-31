package CP_Practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Elimination_of_ring {
	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		ArrayList<Integer> al = new ArrayList<Integer>();
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0 ; i<n ; i++) {
//			arr[i] = sc.nextInt();
			int temp = sc.nextInt();
//			if(i == 0) {
//				al.add(temp);
//			}
//			else {
//				if(al.get(i-1) != temp) {
//					al.add(temp);
//					hs.add(temp);
//				}
//			}
			al.add(temp);
			hs.add(temp);
//			lst.addLast(sc.nextInt());
		}
		if(al.size() < 3) {
			
			System.out.println(al.size());
			return ;
		}
		int temp = hs.size();
		int ans = 0;
		if(temp  == 2) {
			ans = al.size()/2 + 1;
		}
		else {
			ans = al.size();
		}
		System.out.println(ans);
		
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
