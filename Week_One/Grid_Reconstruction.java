package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Grid_Reconstruction {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		int n = sc.nextInt();
		int grid[][] = new int[2][n];
		int high = 2*n;
		int low = 1;
		int p = 0;
		grid[0][0] = high--;
		grid[1][n-1] = high--;
		p = 2;
		for(int i = 0 ; i<n-1 ; i++) {
			if(i%2 == 0) {
				grid[1][i] = low++;
				grid[0][i+1]= low++;
			}
			else {
				grid[0][i+1] = high--;
				grid[1][i] = high--;
			}
		}
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j<n ; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
    }
	public static void main(String[] args) {
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
	
}
