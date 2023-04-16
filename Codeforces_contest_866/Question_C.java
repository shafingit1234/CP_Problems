package Codeforces_contest_866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Question_C {
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
	 public static long mex(long[] arr, int N)
	  {
	    
	    // sort the array
	    Arrays.sort(arr);

	    int mex = 0;
	    for (int idx = 0; idx < N; idx++) {
	      if (arr[idx] == mex) {
	        // Increment mex
	        mex += 1;
	      }
	    }

	    // Return mex as answer
	    return mex;
	  }
	 public static class pair{
		 int a;
		 int b;
		 pair(int a, int b){
			 this.a = a;
			 this.b =b;
		 }
	 }
	 public static void findAnswerTwo() {
		int n = sc.nextInt();
		long arr[] = new long[n];
		long temp_arr[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
			temp_arr[i] = arr[i];
		}
//		if(n == 1) {
//			System.out.println("NO");
//			return ;
//		}
		long mx  = mex(temp_arr, n);
		if(mx == 0) {
			System.out.println("YES");
			return ;
		}
		if(mx == n) {
			System.out.println("NO");
			return ;
		}
		int first_occurence = -1;
		int last_occurence = 0;
		for(int i=0 ; i<n ; i++) {
			if(arr[i] == mx + 1) {
				if(first_occurence == -1) {
					first_occurence = i;
				}
				last_occurence = i;
			}
		}
		if(first_occurence == -1) {
			System.out.println("YES");
			return ;
		}
		for(int i=first_occurence; i<=last_occurence ; i++) {
			arr[i] = mx;
		}
		long temp_mx = mex(arr, n);
		if(mx + 1== temp_mx) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	 }
	public static void findAnswer() {
		int n = sc.nextInt();
		long arr[] = new long[n];
		long temp_arr[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
			temp_arr[i] = arr[i];
		}
//		if(n == 1) {
//			System.out.println("NO");
//			return ;
//		}
		long mx  = mex(temp_arr, n);
		if(mx == 0) {
			System.out.println("YES");
			return ;
		}
		if(mx == n) {
			System.out.println("NO");
			return ;
		}
//		System.out.println(mx);
		HashSet<Long> hs = new HashSet<Long>();
		ArrayList<pair> al = new ArrayList<pair>();
		
		int start = 0;
		int end = 0;
		int count = 0;
		for(int i=0 ; i<n ; i++) {
			if(arr[i] < mx) {
				hs.add(arr[i]);
//				System.out.println(arr[i]);
				if(hs.size() == mx && count == 0) {
					break;
				}
			}
			else {
//				System.out.println();
				while(i < n) {
					if(arr[i] < mx) {
						break;
					}
					i++;
				}
				
				count++;
//				start = i;
				i--;
//				if(hs.size() == mx) {
//					break;
//				}
				if(count > 1) {
					hs.clear();
				}
			}
		}
		if(hs.size() == mx && count == 0) {
			System.out.println("YES");
			return ;
		}
		else if(hs.size() == mx && count == 1) {
			System.out.println("YES");
			return ;
		}
		else {
			if(count > 1 && hs.size() == mx) {
				System.out.println("YES");
				return ;
			}
		}
		System.out.println("NO");
//		if(count > 1 ) {
//			System.out.println("NO");
//		}
//		else {
//			System.out.println("YES");
//		}
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
	public static void main(String[] args) {
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
}
