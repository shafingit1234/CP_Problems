package Codeforces_Educational_Round_153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class B {
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
//		int m = sc.nextInt();
//		int k = sc.nextInt();
//		int a1 = sc.nextInt();
//		int ak = sc.nextInt();
//		int total = a1 + k*ak;
////		System.out.println(total);
//		if(total == m) {
//			System.out.println(0);
//			return ;
//		}
//		else if(total > m) {
//			int mx_ak = m / k;
//			int mx_a1 = m - mx_ak * k;
//			int mn_ak = Math.min(mx_ak, ak);
//			int mn_a1 = Math.min(mx_a1, a1);
//			if(mn_a1 + mn_ak * k == m) {
//				System.out.println(0);
//				return ;
//			}
////			System.out.println(mx_ak + mx_a1);
//			System.out.println(mx_a1 - mn_a1);
//			return ;
//		}
//		int remaining = Math.abs(total - m);
//		int ans = 0;
////		System.out.println(remaining);
//		if(remaining < k) {
//			if(remaining + a1 >= k) {
//				ans += 1;
//			}
//			else {
//				ans += remaining;
//			}
//		}
//		else {
//			int div = remaining/k;
//			remaining = remaining - div*k;
//			ans += div + remaining;
//		}
//		System.out.println(ans);
//		return ;
		long m = sc.nextLong();
        long k = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long temp = m - Math.min(b * k, (m / k) * k);
        temp = Math.max(0, temp - a);
        long ans = (temp / k) + (temp % k);
        if (a >= (k - temp % k)) {
            long ans2 = (1+(temp/k));
            ans = Math.min(ans, ans2);
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
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
