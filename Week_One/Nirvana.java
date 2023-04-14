package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Nirvana {
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
	public static long findProduct(String str) {
		long prod = 1;
		for(int i=0 ; i<str.length(); i++) {
			prod *= (str.charAt(i) - '0');
//			System.out.println(str.charAt(i) - '0');
		}
		return prod;
	}
	public static long findProduct(long num) {
		long prod = 1;
		while(num > 0) {
			prod = prod*(num%10);
			num = num/10;
		}
		return prod;
	}
	public static void findAnswer() {
		StringBuilder sb = new StringBuilder("" + sc.next());
		long mx = findProduct(sb.toString());
		long num = Long.parseLong(sb.toString());
		int dig = sb.length();
		long x = 10;
		for(int i=1 ; i<dig ; i++) {
			num = num - ((num%x) + 1);
			mx = Math.max(mx, findProduct(num));
//			System.out.println(num);
			x *= 10;
		}
		System.out.println(mx);
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
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
