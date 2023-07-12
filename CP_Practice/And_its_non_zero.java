package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class And_its_non_zero {
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
	public static void findAnswer() {
		int[] arr= new int[31];
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		int ans = Integer.MAX_VALUE;
		for(int i=0 ; i<31 ; i++) {
			for(int j = l ; j<=r ; j++) {
				int bit = (j >> i) & 1;
				if(bit == 0) {
					arr[i]++;
				}
			}
			if(arr[i] == 0) {
				System.out.println(0);
				return ;
			}
			ans = Math.min(ans, arr[i]);
		}
		System.out.println(ans);
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
		int tc = sc.nextInt();
//		int tc = 1;
		loader();
		while(tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
	public static int count[][] = new int[200001][32];
	public static void loader() {
		for(int i=1 ; i<= 200000 ; i++) {
			for(int j = 0 ; j<32 ; j++) {
				int bit = (i >> j) & 1;
				count[i][j] = count[i-1][j];
				if(bit != 0) {
					count[i][j]++;
				}
			}
		}
	}
	public static void findAnswerTwo() {
		int l = sc.nextInt();
		int r = sc.nextInt();
		int total_ones = r - l + 1;
		int ans= Integer.MAX_VALUE;
		for(int i = 0 ; i<32 ; i++) {
			int present_ones = count[r][i] - count[l-1][i];
			int present_zeros = total_ones - present_ones;
			if(present_zeros == 0) {
				System.out.println(0);
				return ;
			}
			ans = Math.min(present_zeros, ans);
		}
		System.out.println(ans);
	}
}
