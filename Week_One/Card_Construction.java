package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Card_Construction {
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
		public static int search(long n) {
			int start = 1;
			int end = arr.length-1;
			int ans = -1;
			boolean check = false;
			while(start <= end) {
				int mid = start + (end - start)/2;
				if(arr[mid] == n) {
					check = true;
					ans = mid;
					break;
				}
				if(arr[mid] < n) {
					ans = mid;
					start = mid+1;
//					start = mid-1;
				}
				else {
//					end = mid+1;
					end = mid-1;
				}
			}
			return ans;
		}
		public static void findAnswer() {
			long n = sc.nextLong();
			long count = 0;
			while(true) {
				int idx = search(n);
//				System.out.println(idx);
//				System.out.println(arr[idx]);
				if(idx == -1) {
					break;
				}
				else {
//					System.out.println(arr[idx]);
					long cards_needed = arr[idx];
					count+=(n/cards_needed);
					n = n- ((n/cards_needed)*cards_needed);
				}
				if(n==0) {
					break;
				}
//				System.out.println(arr[idx]);
			}
			System.out.println(count);
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
		public static long arr[] = new long[40000];
		public static void precompute() {
			for(long i=0 ; i<arr.length ; i++) {
				arr[(int)i] = ((3*(i) + 1)*(i))/2;
			}
//			for(int i = 1 ; i<10 ; i++) {
//				System.out.println(arr[i]);
//			}
		}
		public static void main(String[] args) {
			int tc = sc.nextInt();
//			int tc = 1;
			precompute();
//			System.out.println(arr[9999]);
			while(tc-- > 0) {
				findAnswer();
			}
		}
}
