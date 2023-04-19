package Week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Just_Eat_It {
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
		long sum = 0;
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
			sum += arr[i];
		}
		long temp_sum = 0;
		long temp_res = Integer.MIN_VALUE;
		boolean check = true;
		for(int i=0 ; i<n-1 ; i++) {
			temp_sum += arr[i];
			temp_res = Math.max(temp_res, temp_sum);
			if(temp_sum < 0) {
				temp_sum = 0;
			}
		}
		temp_sum = 0;
		for(int i=1 ; i<n ; i++) {
			temp_sum += arr[i];
			temp_res = Math.max(temp_res, temp_sum);
			if(temp_sum < 0) {
				temp_sum = 0;
			}
		}
		
		if(temp_res >= sum) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
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
