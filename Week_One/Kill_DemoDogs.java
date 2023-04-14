package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Kill_DemoDogs {
	public static long mod = (long) (1e9 + 7);
	public static FastScanner sc = new FastScanner();
	public static long findSquareSummation(long a) {
//		long ans= ((a*(a+1)*((2*a) + 1))%mod)/3;
		long ans = ((((a*(a+1))%mod)*(2*(a) + 1)%mod)%mod);
		ans = (ans*(modexp((long)3, mod-2)))%mod;
		return ans;
	}
	public static long findNormalSummation(long a) {
//		long ans = ((a*(a + 1))%mod)/2;
		long ans = (a*(a+1))%mod;
		ans = (ans*modexp((long)2, mod-2))%mod;
//		long ans = ((a*(a+1))%mod/2;
		return ans;
	}
	public static void findAnswer() {
		long n = sc.nextLong();
		long ans = ((findSquareSummation((n-1)%mod)) + findNormalSummation((n-1)%mod) + (n*n)%mod)%mod;
		System.out.println((2022*ans)%mod);
		return ;
	}
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
