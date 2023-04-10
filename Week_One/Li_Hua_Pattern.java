package Week_One;

import java.util.Scanner;

public class Li_Hua_Pattern {
	public static void findAnswer() {
		int n = sc.nextInt();
		long k = sc.nextLong();
		int[][] grid = new int[n][n];
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int temp = (int)Math.ceil(n/2);
//		(i , j) == (n- i- 1 , n- j - 1)
		long count = 0;
		for(int i=0 ; i<n; i++) {
			for(int j=0 ; j<n ; j++) {
				if(grid[i][j] != grid[n-i-1][n-j-1]) {
					count++;
//					grid[i][j] = grid[n-i-1][n-j-1];
				}
			}
			
		}
//		System.out.println("YES");
		count = count/2;
		if(count > k) {
			System.out.println("NO");
			return ;
		}
		int diff = (int)(k - count);
		if(isOdd(n) || !isOdd(diff)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		return;
	}
	public static boolean isOdd(int n){
        return (n&1) == 1;
    }
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
