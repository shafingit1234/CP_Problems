package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Even_Subarrays {
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
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] =sc.nextInt();
		}
		
		long ans = 0;
//		HashMap<Long , Long> hm = new HashMap<Long, Long>();
		long map[] = new long[2*n+1];
		int xor_so_far =0;
//		hm.put(xor_so_far , 1l);
		map[xor_so_far]++;
		for(int i=0 ; i<n; i++) {
			xor_so_far = xor_so_far ^ arr[i];
			for(int p = 0 ; p*p < 2*n ; p++) {
				int B = ((p*p) ^ xor_so_far);
				if(B < 2*n ) {
//					ans += hm.get(B);
					ans += map[B];
				}
			}
//			if(hm.containsKey(xor_so_far) == false) {
//				hm.put(xor_so_far , 1l);
//			}
//			else {
//				hm.put(xor_so_far, hm.get(xor_so_far) + 1);
//			}
			map[xor_so_far]++;
		}
		long total_subarrays = 1L * n * (n + 1)/2;
		System.out.println(total_subarrays - ans);
		
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
