package Codeforces_contest_880;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class C {
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
		int a = sc.nextInt();
		int b  =sc.nextInt();
		int c = sc.nextInt();
		long k = sc.nextLong();
		if(c < b || c < a) {
			System.out.println(-1);
			return ;
		}
		boolean check = true;
		int mn_b = (int)Math.pow(10, b-1);
		int mx_b = (int)Math.pow(10 , b) - 1;
		int mn_c = (int)Math.pow(10, c-1);
		int mx_c = (int)Math.pow(10 , c) - 1;
		for(int i= (int)Math.pow(10, a-1) ; i < (int)Math.pow(10, a) ; i++) {
			//find range of b.
//			int mn_one = (int)Math.pow(10, b-1);
//			int mx_one = (int)Math.pow(10 , b) - 1;
//			int mn_two = (int)Math.pow(10, c-1) - i;
//			int mx_two = (int)Math.pow(10 , c) - i - 1;
			int mn_final = Math.max(mn_b, mn_c - i);
			int mx_final = Math.min(mx_b, mx_c - i);
			if(mn_final > mx_final) {
				continue;
			}
			int total = (mx_final - mn_final) + 1;
			if(k <= total) {
				long ans = i + (mn_final + k - 1);
				check = false;
				System.out.println(i + " + " + (mn_final + k - 1) + " = " + ans);
				break;
			}
			k -= total;
		}
		if(check == true) {
			System.out.println(-1);
			return ;
		}
		return ;
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
