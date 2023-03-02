package codeforces_contest_Div3_855;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QuestionThree {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int testcases = sc.nextInt();
		int i=0;
		PriorityQueue<Integer> pq
        = new PriorityQueue<Integer>(
            Collections.reverseOrder());
		while(i < testcases) {
			int n= sc.nextInt();
			long ans = 0;
			for(int j=0 ; j<n ; j++) {
				int num = sc.nextInt();
				if(num > 0) {
					pq.add(num);
				}
				else if(num == 0) {
					if(pq.size() >= 1) {
						ans = ans + pq.poll();
					}
				}
			}
			pq.clear();
			System.out.println(ans);
			i++;
		}
	}
}
