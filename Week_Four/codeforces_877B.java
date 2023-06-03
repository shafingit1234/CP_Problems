package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class codeforces_877B {
	public static FastScanner sc = new FastScanner();
	public static long mod = (long)(1e9 + 7);
	public static Long modexp(Long a,Long b)
    { Long ans=(long)1;
        while(b>0)
        {
          if((b&1)!=0)// b%2!=0
          {
              ans=(ans*a)%mod;
          }
          a=(a*a)%mod;
          b=b>>1;  
        }
        return ans;
    }
	public static int dpUtil(int x, int i, int len, String s, int[][] dp) {
        if (x > 3)
            return -10000;
        if (i == len)
            if (x == 3)
                return 0;
            else
                return -10000;
 
        if (dp[x][i] != -1)
            return dp[x][i];
 
        int ans = 0;
        ans = Math.max(ans, dpUtil(x, i + 1, len, s, dp));
        ans = Math.max(ans, dpUtil(x + 1, i + 1, len, s, dp));
        if ((x == 1 || x == 3) && s.charAt(i) == 'a')
            ans++;
        else if (x == 2 && s.charAt(i) == 'b')
            ans++;
        return dp[x][i] = ans;
    }
	public static void findAnswer() {
//        InputReader ir = new InputReader(System.in);
        
        String s = sc.next();
        int len = s.length();
 
        int[][] dp = new int[3 + 1][len + 1];
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= len; j++) {
                dp[i][j] = -1;
            }
        }
 
        int ans = 0;
        ans = Math.max(ans, dpUtil(1, 0, len, s, dp));
        ans = Math.max(ans, dpUtil(2, 0, len, s, dp));
        ans = Math.max(ans, dpUtil(3, 0, len, s, dp));
        for(int i=1 ; i<=3 ; i++) {
        	for(int j=0 ;j<= len ; j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println();
        }
//        System.out.println(ans);
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
	public static final Random random = new Random();
    public static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
	public static void main(String[] args) {
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
