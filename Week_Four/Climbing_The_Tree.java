package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Climbing_The_Tree {
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
	public static boolean check(long mn, long mx, long newmn, long newmx) {
		if(mn > newmx) {
			return false;
		}
		else if(mx < newmn) {
			return false;
		}
		return true;
	}
	public static void findAnswer() {
		int q = sc.nextInt();
		
		long mn = 1;
		long mx = (long) 1e18;
		ArrayList<Long> ans = new ArrayList<Long>();
		while(q-- > 0) {
			int type = sc.nextInt();
			long newmn = 0;
			long newmx = (long) 1e18;
			if(type == 1) {
				long a = sc.nextLong();
				long b = sc.nextLong();
				long n = sc.nextLong();
				if(n >= 2) {
					newmn = (n-2)*(a-b) + a + 1;
				}
				newmx = (n-1)*(a-b) + a;
				if(check(mn, mx, newmn, newmx)) {
					ans.add(1l);
					mn = Math.max(newmn, mn);
					mx = Math.min(newmx, mx);
				}
				else {
					ans.add(0l);
				}
			}
			else {
				long a = sc.nextLong();
				long b = sc.nextLong();
				newmn = mn - a;
				newmx = mx - a;
				long len = (newmn + a-b - 1)/(a-b);
				long len1 = (newmx + a-b -1)/(a-b);
				if(newmn <= 0 && newmx <= 0) {
					ans.add(1l);
				}
				else if(len == len1) {
					if(len <= 0) {
						ans.add(1l);
					}
					else {
						ans.add(len + 1);
					}
				}
				else {
					ans.add((long) -1);
				}
			}
		}
		for(long i : ans) {
			System.out.print(i + " ");
		}
		System.out.println();
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
