package codeforces_contest_div2_860;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Question_D {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n=sc.nextInt();
		int arr[] = new int[n];
		LinkedList<Integer> pos = new LinkedList<>();
		LinkedList<Integer> neg = new LinkedList<>();
		LinkedList<Integer> zeros=new LinkedList<>();
		int mx = Integer.MIN_VALUE;
		int mn = Integer.MAX_VALUE;
		boolean check = false;
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
			mx = Math.max(arr[i], mx);
			mn = Math.min(arr[i], mn);
			if(arr[i] == 0) {
//				check = true;
				zeros.add(0);
			}
			else if(arr[i] > 0) {
				pos.add(arr[i]);
			}
			else {
				neg.add(arr[i]);
			}
		}
		Collections.sort(pos);
		Collections.sort(neg);
		int a = 0;
		if(neg.size() == 0 && pos.size() == 0) {
			System.out.println("NO");
			return ;
		}
		System.out.println("YES");
		int diff = mx - mn;
		ArrayList<Integer> ans= new ArrayList<Integer>();
		for(int i : zeros) {
			a++;
			ans.add(i);
		}
		int sum=0;
		int p=0;
		
		while(pos.size() >0 && neg.size() > 0) {
			if(sum > 0) {
				sum += neg.getFirst();
				ans.add(neg.getFirst());
				neg.removeFirst();
			}
			else {
				//add positive number
				sum += pos.getFirst();
				ans.add(pos.getFirst());
				pos.removeFirst();
			}
		}
		while(neg.size() > 0) {
			ans.add(neg.getFirst());
			neg.removeFirst();
		}
		while(pos.size() > 0) {
			ans.add(pos.getFirst());
			pos.removeFirst();
		}
		for(int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		while(testcase > 0) {
			findAnswer();
			testcase--;
		}
	}
}
