package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Almost_all_multiples {
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
		int n = sc.nextInt();
		int x = sc.nextInt();
		int temp = x;
		int arr_p[] = new int[n+1];
		arr_p[1] = x;
		arr_p[n] = 1;
		for(int i=2 ; i<n ; i++) {
			arr_p[i] = i;
		}
		if(n%x != 0) {
			System.out.println(-1);
			return ;
		}
		int p = n/x;
		//find factors of p;
		int k = 2;
		ArrayList<Integer> factors = new ArrayList<>();
		for(k=2 ; k<=p ; k++) {
			if(p%k == 0) {
				while(p%k == 0) {
					p = p/k;
					factors.add(k);
				}
			}
		}
		
		for(int i : factors) {
			arr_p[x] = i*x;
			x = i*x;
			if(x >= n) {
				break;
			}
		}
		for(int i=1 ; i<=n ; i++) {
			System.out.print(arr_p[i] + " ");
		}
		System.out.println();
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
