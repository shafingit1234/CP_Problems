package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Ira_and_Flamenco {
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
		int m = sc.nextInt();
		long[] a = new long[n];
		HashMap<Long, Long> hm = new HashMap<>();
		for(int i = 0 ; i<n ; i++) {
			a[i] = sc.nextLong();
			hm.put(a[i] , hm.getOrDefault(a[i], (long) 0) + 1);
		}
		Arrays.sort(a);
		HashSet<Long> hs =new HashSet<Long>();
		int start = 0;
		int end= 0;
		long ans = 0;
		while(end <= n) {
			if(hs.size() == m) {
				long mult = 1;
				for(long val : hs) {
					long b =hm.get(val);
//					System.out.print(val + " " + b + "   ");
					if(b == 1) {
						continue;
					}
					mult = ((mult)*(b))%mod;
				}
//				System.out.println();
				ans = (ans + mult)%mod;
				//shift the window
				hs.remove(a[start]);
//				start++;
				long temp = a[start];
				while(start < n && temp == a[start]) {
					start++;
				}
				if(end < start) {
					end = start;
				}
				continue;
			}
			if(end == n || start >= n) {
				break;
			}
			if(hs.size() < m && Math.abs(a[start] - a[end]) < m) {
				hs.add(a[end]);
			}
			else if(hs.size() < m && Math.abs(a[start] - a[end]) >= m) {
				hs.remove(a[start]);
//				start++;
				long temp = a[start];
				while(start < n && temp == a[start]) {
					start++;
				}
				if(end < start) {
					end = start;
				}
				continue;
			}
			end++;
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
