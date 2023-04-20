package Week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Negatives_And_Positives {
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
		long arr[] = new long[n];
		for(int i=0 ; i<n  ; i++) {
			arr[i] =sc.nextLong();
		}
		if(n == 1) {
			System.out.println(arr[0]);
			return ;
		}
//		if(n == 2) {
//			if(arr[0] < 0 && arr[1] < 0) {
//				System.out.println(Math.abs(arr[0]) + Math.abs(arr[1]));
//			}
//			else {
//				System.out.println(Math.max(Math.abs(arr[0]) + arr[1], Math.abs(arr[1]) +arr[0]));
//			}
//			return ;
//		}
		
		long sum_so_far= 0;
		long negatives = 0;
		long zeros = 0;
		long mn = Integer.MAX_VALUE;
		for(int i=0 ; i<n ; i++) {
			if(arr[i] < 0) {
				negatives++;
			}
			if(arr[i]==0) {
				zeros++;
			}
			mn = Math.min(mn,  Math.abs(arr[i]));
			sum_so_far += Math.abs(arr[i]);
		}
//		if(sum_so_far + )
//		sum_so_far = Math.max(sum_so_far +arr[n-1], sum_so_far + Math.abs(arr[n-1]) - Math.abs(arr[n-2]));
//		System.out.println(sum_so_far);
		if(negatives%2 != 0 && zeros == 0) {
			sum_so_far -= 2*(mn);
		}
		System.out.println(sum_so_far);
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
