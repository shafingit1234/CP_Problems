package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Week_One.X_Magic_Pair.FastScanner;

public class Z_Three_Numbers {
	public static FastScanner sc = new FastScanner();
	public static Integer[][] dp ;
	public static int checkAnswer(int K, int S, int cnt) {
		if(S < 0) {
			return 0;
		}
		if(S == 0 && cnt == 3) {
			dp[S][cnt]=1;
			return 1;
		}
		if(cnt>=3) {
			return 0;
		}
		if(dp[S][cnt] != null) return dp[S][cnt];
//		int sp1 = checkAnswer()
		int sp1 = 0;
		for(int i=0 ; i<=K ; i++) {
//			if()
			sp1 += checkAnswer(K , S - i , cnt+1);
		}
		dp[S][cnt] = sp1;
		return sp1;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		dp = new Integer[k+1][4];
		System.out.println(checkAnswer(n , k, 0));
	}
	public static void main(String[] args) {
		findAnswer();
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
}
