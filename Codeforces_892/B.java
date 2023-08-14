package Codeforces_892;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class B {
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
//		ArrayList<ArrayList<Long>> al = new ArrayList<>();
		ArrayList<Long> second_max = new ArrayList<>();
		ArrayList<Long> first_min = new ArrayList<>();
		int temp = n;
		while(n-- > 0) {
			int m = sc.nextInt();
			long arr[] = new long[m];
			for(int i = 0 ; i<m ; i++) {
				arr[i] = sc.nextLong();
			}
			Arrays.sort(arr);
			if(arr.length == 1) {
				second_max.add(arr[0]);
				first_min.add(arr[0]);
			}
			else {
				second_max.add(arr[1]);
				first_min.add(arr[0]);
			}
		}
		Collections.sort(second_max);
		Collections.sort(first_min);
//		long sum = second_max.get(0) + second.
		int j = 0;
		long sum = 0;
		while(j < temp-1) {
			sum += second_max.get(second_max.size() - j - 1);
			j++;
		}
		sum += first_min.get(0);
		System.out.println(sum);
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
