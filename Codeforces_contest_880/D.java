package Codeforces_contest_880;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class D {
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
//	public static long chance = 0;
//	public static long choice = 0;
//	public static int last_considered = -1;
//	public static int n;
//	public static int k;
//	public static long m;
//	public static void solve(long y , long[] arr) {
//		if(y <= last_considered || y > m) {
//			return ;
//		}
//		int i = upper_bound(0 , n , arr , y);
//		int j = lower_bound(0 , n , arr, y);
//		
//		
//		i = i - k;
//		long low = -1;
//		if(i < 0 || arr[i] <= y) {
//			low = i < 0 ? 0 : y + 1 - (y - arr[i] + 1)/2;
//		}
//		else {
//			return ;
//		}
//		j += k-1;
//		long hi =  ((j >= n) ? m+1 : (y + (arr[j] - y + 1)/2));
//		if(hi - low > chance) {
//			chance = hi - low;
//			choice = y;
//		}
//	}
//	public static int lower_bound(int i, int n2, long[] arr, long y) {
//		// TODO Auto-generated method stub
//		int low = 0;
//		int high = arr.length;
//		int mid;
//		while(low < high) {
//			mid = low + (high - low)/2;
//			if(y <= arr[mid]) {
//				high = mid;
//			}
//			else {
//				low = mid+1;
//			}
//		}
//		if(low <arr.length && arr[low] < y) {
//			low++;
//		}
//		
//		return low;
//	}
//	public static int upper_bound(int i, int n2, long[] arr, long y) {
//		// TODO Auto-generated method stub
//		int low = 0;
//		int high = arr.length;
//		int mid;
//		
//		while(low < high && low != arr.length) {
//			mid = low + (high - low)/2;
//			if(y >= arr[mid]) {
//				low = mid+1;
//			}
//			else {
//				high = mid;
//			}
//		}
//		if(low == arr.length) {
//			return -1;
//		}
//		return low;
//	}
//	public static void findAnswer() {
//		n = sc.nextInt();
//		m = sc.nextLong();
//		k = sc.nextInt();
//		long arr[] = new long[n];
//		for(int i=0 ; i<n ; i++) {
//			arr[i] = sc.nextLong();
//		}
////		arr[n+1] = m+1;
//		Arrays.sort(arr);
//		last_considered = -1;
//		
//		solve(0 , arr);
//		for(int i=0 ; i < n ; i++) {
//			solve(arr[i]-2 , arr);
//			solve(arr[i]-1 , arr);
//			solve(arr[i] , arr);
//			solve(arr[i] + 1,arr);
//			solve(arr[i]+2 , arr);
//		}
//		System.out.println(chance + " " + choice);
//	}
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
//			findAnswer();
			findAnswerTwo();
		}
	}
	public static int start = 0;
	public static int end = 0;
	public static void findAnswerTwo() {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		long m = sc.nextLong();
		int k = sc.nextInt();
		long arr[] = new long[n+1];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
		}
		arr[n] = m+1;
		Arrays.sort(arr);
		start = 0;
		end = 0;
		//what if we picked ticket numbered 0;
		long total_targets = findTargets(0 , arr, m , k);
		long pickedValue = 0;
		
		for(int i=0; i<n ; i++) {
			long minp = (i == 0) ? Math.max(0, arr[i]-2) : Math.max(arr[i]-2, arr[i-1] + 3);
			long maxp = Math.min(m, arr[i] + 2);
			for(long p = minp ; p <= maxp ; p++) {
				long cnt = findTargets(p , arr, m, k);
				if(cnt > total_targets) {
					total_targets = cnt;
					pickedValue = p;
				}
			}
		}
		System.out.println(total_targets + " " + pickedValue);
	}
	public static long findTargets(long i, long[] arr, long m, int k) {
		// TODO Auto-generated method stub
		int n = arr.length-1;
		while(start < n && arr[start] < i) {
			start++;
		}
		while(end < n && arr[end] <= i) {
			end++;
		}
		long min = end < k ? 0 : (i + arr[end - k])/2 + 1;
		long max = start + k - 1 >= n ? m : (arr[start + k - 1] + i - 1)/2;
		
		return Math.max(0l, max - min + 1);
	}
}
