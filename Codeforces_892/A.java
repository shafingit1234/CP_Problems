package Codeforces_892;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class A {
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
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		ArrayList<Long> st_one = new ArrayList<>();
		ArrayList<Long> st_two = new ArrayList<>();
		int j = -1;
		boolean check = true;
		int count = 1;
		for(int i = 1 ; i<arr.length ; i++) {
			//just find one value that doesnot divide all the elements.
			if(arr[i-1]!=arr[i]) {
//				st_one.add()
//				st_one.add(arr[i-1]);
				j = i;
				break;
			}
			count++;
		}
		if(j == -1) {
			System.out.println(-1);
			return ;
		}
//		System.out.println();
		System.out.println(count + " " + (arr.length - count));
		for(int i = 0 ; i < j ; i++) {
//			st_one.add(arr[i]);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for(int i = j ; i < n ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
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
//		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
