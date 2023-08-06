package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

import javax.crypto.spec.GCMParameterSpec;

//import Java_CP_Template.Template_One.FastScanner;

public class Required_Length {
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
	public static HashMap<Long, Long> dp ;
	public static HashSet<Integer> digits;
	public static void findAnswer() {
		int n = sc.nextInt();
		long x = sc.nextLong();
//		digits = utils(x);
		
		dp = new HashMap<>();
//		return dfs(x, n);
		long ans = dfs(x, n);
		System.out.println(ans);
	}
	public static long dfs(long x, int n) {
		if(dp.containsKey(x) == true) {
			return dp.get(x);
		}
		int digits = utils(x);
		if(digits > n) {
			HashSet<Integer> hs = new HashSet<>();
			long t = x;
			while(t > 0) {
				hs.add((int)(t%10));
				t = t/10;
			}
			if(dp.containsKey(x) == false) {
				dp.put(x , (long) -1);
			}
			
			if(n == 1 && hs.contains(0)) {
				dp.put(x , (long) 1);
				return 1;
			}
//			digits.clear();
			return -1;
		}
		if(digits == n) {
			if(dp.containsKey(x) == false) {
				dp.put(x , (long) 0);
			}
			
//			digits.clear();
			return 0;
		}
		
		long ans = Integer.MAX_VALUE;
		long temp = x;
		while(temp > 0) {
			int dig = (int)(temp%10);
			if(dig == 1) {
				temp = temp/10;
				continue;
			}
			temp = temp/10;
			long t= dfs(x*dig , n) + 1;
			if(t == 0) {
				continue;
			}
			ans = Math.min(ans,t);
		}
		if(ans == Integer.MAX_VALUE) {
			if(dp.containsKey(x) == false) {
				dp.put(x , (long) -1);
			}
			return -1;
		}
//		digits.clear();
		if(dp.containsKey(x) == false) {
			dp.put(x , ans);
		}
		dp.put(x, ans);
		return ans;
	}
	
	public static int utils(long x) {
//		HashSet<Integer> hs = new HashSet<>();
		long temp = x;
		int count = 0;
		while(temp > 0) {
//			hs.add((int)(temp%10));
			count++;
			temp = temp/10;
		}
		return count;
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
