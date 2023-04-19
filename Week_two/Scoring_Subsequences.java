package Week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Scoring_Subsequences {
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
	public static BigInteger factorial(int N)
    {
        // Initialize result
        BigInteger f
            = new BigInteger("1"); // Or BigInteger.ONE
 
        // Multiply f with 2, 3, ...N
        for (int i = 2; i <= N; i++)
            f = f.multiply(BigInteger.valueOf(i));
 
        return f;
    }
	public static void findAnswer() {
		int n = sc.nextInt();
		int[] arr = new int[n];
		long[] prod = new long[n+1];
		BigInteger[] mul = new BigInteger[n+1];
		mul[0] = new BigInteger("1");
//		long prod = 1;
		prod[0] = 1;
		for(int i=0 ; i<n ; i++) {
			arr[i]= sc.nextInt();
//			prod*=arr[i];
			prod[i+1] = prod[i] * arr[i];
			mul[i+1] = mul[i].multiply(BigInteger.valueOf(arr[i]));
		}
//		System.out.println(mul[n]);
		int ans[] = new int[n];
		for(int len = 1 ; len <= n ; len++) {
			int start = 0;
			int end = len;
			int res= -1;
			while(start <= end) {
				int mid = start + (end - start)/2;
//				long temp = prod[len]/prod[mid];
				BigInteger bg = mul[len].divide(mul[mid]);

				System.out.println(bg + " " + mul[len] + " " + mul[mid]);
				if(bg.compareTo(factorial(len- mid)) >= 0) {
//					res = mid;
					start = mid+1;
//					end  = mid-1;
				}
				else {
					res = mid;
					end = mid-1;
//					start = mid + 1;
				}
			}
			ans[len-1] = len - res;
		}
		for(int i=0 ; i < ans.length ; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i]  = sc.nextInt();
		}
		int ans[] = new int[n];
		ans[0] = 1;
		int res = -1;
		System.out.print(ans[0] + " ");
		for(int len = 1 ; len < n ; len++) {
			int start = 0;
			int end = len;
			while(start <= end) {
				int mid = start + (end - start)/2;
				if(arr[mid] >= (len+1) - mid) {
					res = mid;
					end = mid-1;
				}
				else {
					start = mid+1;
				}
			}
			ans[len] = (len + 1)- res;
			System.out.print(ans[len] + " ");
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
//			findAnswer();
			findAnswerTwo();
		}
	}
}
