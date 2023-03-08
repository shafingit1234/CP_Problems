package CP_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Dividing_islands {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt();
		int[] cnt = new int[31];
		for(int i=1 ; i<= n ; i++) {
			cnt[i] = sc.nextInt();
		}
		int width = a+c;
		int length = Math.max(b , d);
		char [][] ans = new char[101][101];
//		Arrays.fill(ans, '.');
		for(int i=0 ; i<101 ; i++) {
			Arrays.fill(ans[i],'.');
		}
		int curr = 1;
		boolean move_up = false;
		//if a is odd move from down to up.
		if((a&1) == 1) {
			move_up = true;
		}
		for(int i=0 ; i<a; i++) {
			if(move_up) {
				for(int j = b-1 ; j>=0 ; j--) {
					//start filling characters.
					ans[j][i] = (char)('a' + (curr - 1));
					cnt[curr]--;
					if(cnt[curr] == 0) {
						curr++;
					}
				}
			}
			else {
				for(int j=0 ; j<b ; j++) {
					ans[j][i] = (char)('a' + (curr - 1));
					cnt[curr]--;
					if(cnt[curr] == 0) {
						curr++;
					}
				}
			}
			move_up = !move_up;
		}
		for(int i=0 ; i<c ; i++) {
			if(move_up) {
				for(int j=d-1 ; j>=0; j--) {
					ans[j][i + a] = (char)('a' + (curr - 1));
					cnt[curr]--;
					if(cnt[curr] == 0) {
						curr++;
					}
				}
			}
			else {
				for(int j=0 ; j<=d-1 ; j++) {
					ans[j][i+ a] = (char)('a' + (curr - 1));
					cnt[curr]--;
					if(cnt[curr] == 0) {
						curr++;
					}
				}
			}
			move_up = !move_up;
		}
		//print yes and then print the pattern
		System.out.println("YES");
		for(int i=0 ; i<Math.max(b, d) ; i++) {
			for(int j=0 ; j<a+c ; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
		return ;
	}
}

