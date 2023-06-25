package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Absolute_Sorting {
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
			arr[i] = sc.nextInt();
		}
		
		long mx = 0l;
		long mn = (long) (1e9);
		for(int i=0 ; i<arr.length-1 ; i++) {
			long sub = (long)(arr[i] + arr[i+1])/2;
			long sub_two = (long)(arr[i] + arr[i+1] + 1)/2;
			if(arr[i] < arr[i+1]) {
				mn = Math.min(mn, sub);
			}
			else if(arr[i+1] < arr[i]){
				mx = Math.max(mx, sub_two);
			}
		}
		if(mn >= mx) {
			System.out.println(mx);
			return ;
		}
		System.out.println(-1);
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
		int tc = sc.nextInt();
//		boolean check = false;
//		int tc = 1;
		while(tc-- > 0) {
//			if(tc == )
			findAnswer();
		}
//		for(int i=1 ; i<=tc ; i++) {
//			if(tc == 65) {
//				findAnswer(true);
//				continue;
//			}
//			findAnswer(false);
//		}
	}
}
