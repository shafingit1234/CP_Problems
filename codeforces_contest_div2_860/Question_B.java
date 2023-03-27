package codeforces_contest_div2_860;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Question_B {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		while(testcase > 0) {
			int m= sc.nextInt();
			boolean state[] = new boolean[m];
			HashMap<Integer , ArrayList<Integer>>hm =new HashMap<>();
			HashMap<Integer , Integer> freq = new HashMap<>();
			for(int i=0 ; i<m ; i++) {
				int k = sc.nextInt();
				int a[]= new int[k];
				
				for(int j=0 ; j<k ; j++) {
					a[j] = sc.nextInt(); 
					if(hm.containsKey(a[j]) == false) {
						hm.put(a[j], new ArrayList<>());
						freq.put(a[j] , 0);
					}
					hm.get(a[j]).add(i);
					freq.put(a[j], i);
					
					
				}
			}
			int ans[] = new int[m];
			for(int k : freq.keySet()) {
				if(freq.get(k) <= m) {
					ans[freq.get(k)] = k;
				}
			}
			boolean check = true;
			for(int k=0 ; k<m ; k++) {
				if(ans[k] == 0) {
					check = false;
				}
			}
			if(check == false) {
				System.out.println("-1");
				testcase--;
				continue;
			}
			for(int j=0 ; j<m ; j++) {
				System.out.print(ans[j] + " ");
			}
			System.out.println();
			testcase--;
		}
	}
}
