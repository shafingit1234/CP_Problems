package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Robot_In_A_HallWay {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		int m = sc.nextInt();
		int res = Integer.MAX_VALUE;
		int grid[][] = new int[2][m];
		for(int i=0 ; i<2 ; i++) {
			for(int j=0 ; j<m ; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		grid[0][0] = -1;
		//find the scenario when the tourist goes straight right then down and then straight left.
		int right_to_left[][] = new int[2][m];
		int arrive = 1;
		for(int i=1 ; i<m ; i++) {
			right_to_left[0][i] = Math.max(arrive, grid[0][i]+1);
			arrive = right_to_left[0][i];
			arrive++;
		}
		for(int i=m-1 ; i>=0 ; i--) {
			right_to_left[1][i] = Math.max(arrive, grid[1][i] + 1);
			arrive = right_to_left[1][i];
			arrive++;
		}
//		find a scenario when the tourist goes one step down initially, then goes straight left, take an up turn, then goes straight right. 
		res = right_to_left[1][0];
		arrive = 1;
		int left_to_right[][] = new int[2][m];
		for(int i=1 ; i<m ; i++) {
			left_to_right[1][i]= Math.max(arrive, grid[1][i] + 1);
			arrive= left_to_right[1][i];
			arrive++;
		}
		for(int i=m-1 ; i>=0 ;i--) {
			left_to_right[0][i] = Math.max(arrive, grid[0][i] + 1);
			arrive = left_to_right[0][i];
			arrive++;
		}
//		once done, try out different possibilities so as to find out the correct answer.
//		assume when you are at even coloumn, you go one step down, then you will have to consider left_to_right option,
//		assume when you are at odd coloumn, you go one step up, then you will have to consider right_to_left option.
		arrive =0 ;
		for(int col = 0; col <m-1 ; col++) {
			int len = 2*(m - col - 1);
			if(col%2 == 0) {
//				move one step down.
				for(int i=0; i<2 ; i++) {
					arrive = Math.max(arrive, grid[i][col] +1) + 1;
				}
//				consider left_to_right
				res = Math.min(res, Math.max(left_to_right[0][col+1], arrive+len - 1));
			}
			else {
//				move one step up;
				for(int i = 1 ; i>=0 ; i--) {
					arrive = Math.max(arrive, grid[i][col] + 1) + 1;
				}
//				consider right_to_left
				res = Math.min(res, Math.max(right_to_left[1][col+1],arrive+len - 1));
			}
//			arrive++;
		}
		System.out.println(res);
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
