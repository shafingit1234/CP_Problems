package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class New_Years_Problem {
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
	public static boolean check(long mid, long[][] arr) {
		boolean covered[] = new boolean[arr[0].length];
		boolean f = false;
		for(int i=0 ; i<arr.length ; i++) {
			int cnt = 0;
			for(int j = 0 ; j<arr[i].length ; j++) {
				if(arr[i][j] >= mid) {
					covered[j] = true;
					cnt++;
				}
			}
			if(cnt > 1) {
				f = true;
			}
		}
//		if(arr.length > arr[0].length - 1 && f == false) {
//			return false;
//		}
		for(int i=0 ; i<arr[0].length ; i++) {
			if(covered[i] == false) {
				return false;
			}
//			f = (f&covered[i]);
		}
		
		return f;
	}
	public static void findAnswer() {
		int m = sc.nextInt();
		int n = sc.nextInt();
		long arr[][] = new long[m][n];
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				arr[i][j] = sc.nextLong();
			}
		}
		long start = 0;
		long end = 1000000001;
		long ans = start;
		while(start <= end) {
			long mid = start + ( end - start )/2;
//			System.out.println("mid " + mid);
			if(check(mid , arr) == true) {
				ans = mid;
//				System.out.println("ans"+ " " + ans);
				start = mid+1; 
				
			}
			else {
				end = mid-1;
//				start = mid+1;
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
