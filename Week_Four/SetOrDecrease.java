package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class SetOrDecrease {
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
	public static boolean isValid(long mid, long prefix[], long arr[], long k) {
		//mid = x+y;
		for(long y = 0 ; y <= mid ; y++) {
			if(y > arr.length-1) {
				return false;
			}
			long x = mid - y;
			long temp = (arr[0] - x) + prefix[arr.length - 1 - (int)y] - prefix[0] + (y)*(arr[0]-x);
			if(temp <= k) {
				return true;
			}
		}
		return false;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		long k = sc.nextLong();
		long arr[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
		}
//		ruffle(arr, n)
		ruffleSort(arr);
//		Arrays.sort(arr);
		long prefix[] = new long[n];
		prefix[0]= arr[0];
		for(int i=1 ; i<n ; i++) {
			prefix[i] = prefix[i-1]+arr[i];
		}
		long start = -1;
		long ans = -1;
		long end = Integer.MAX_VALUE;
		while(start+1 < end) {
			long mid = start + (end - start)/2;
			//mid = x + y;
			//try to decrease a1 to a1-x then make last y elements equal to a1-y in y operations
			//if summation becomes <= k after above operation, check for a minimum value of mid.
//			System.out.println(start + "\t" + mid + "\t" + end);
			if(isValid(mid, prefix, arr, k) == true) {
				ans = mid;
				end = mid;
			}
			else {
				start = mid;
			}
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
    public static void ruffleSort(long[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            long oi = random.nextInt(n), temp = a[(int) oi];
            a[(int) oi] = a[i];
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
