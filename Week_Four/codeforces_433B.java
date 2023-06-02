package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class codeforces_433B {
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
		int[] nums = new int[n];
		long[] temp = new long[n+1];
		long[] prefix = new long[n+1];
		for(int i=0 ; i<n ; i++) {
			nums[i] = sc.nextInt();
			prefix[i+1] = nums[i] + prefix[i];
		}
//		Arrays.sort(nums);
		ruffleSort(nums);
		for(int i=0 ; i<nums.length ; i++) {
			temp[i+1] = nums[i] + temp[i];
		}
		int m = sc.nextInt();
		while(m > 0) {
			m--;
			int type = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			if(type == 1) {
				long ans =prefix[r] - prefix[l-1];
				System.out.println(ans);
			}
			else if(type == 2) {
				long ans = temp[r] - temp[l-1];
				System.out.println(ans);
			}
		}
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
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
