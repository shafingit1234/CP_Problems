package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class The_Meeting_Place_Cannot_Be_Changed {
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
	public static boolean isValid(double mid, long[] speed, long[]arr) {
		double minR = Integer.MAX_VALUE;
		double maxL = Integer.MIN_VALUE;
		for(int i=0 ; i<arr.length ; i++) {
			minR = Math.min(minR, arr[i] + speed[i]*mid);
			maxL = Math.max(maxL ,arr[i] - speed[i]*mid);
		}
		if(minR >= maxL) return true;
		return false;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		long arr[] = new long[n];
		long speed[] = new long[n];
		for(int i=0 ; i<n ; i++) arr[i] = sc.nextLong();
		for(int i=0 ; i<n ; i++) speed[i] = sc.nextLong();
		double start = 0;
		double end = 1e9;
		double ans = 0l;
		int i=0;
		
		while(i <= 100) {
			double mid = (end + start)/2;
			if(isValid(mid , speed, arr) == true) {
//				ans = mid;
				end= mid;
			}
			else {
				start = mid;
			}
			i++;
		}
		System.out.println(end);
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
