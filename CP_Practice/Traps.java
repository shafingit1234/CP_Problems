package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Traps {
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
	
//	public static long arr[];
	public static class pair{
		long ele;
		int idx;
		pair(long ele, int idx){
			this.ele = ele;
			this.idx = idx;
		}
	}
	public static class customSort implements Comparator<pair>{
		public int compare(pair p1, pair p2) {
			if(p1.ele > p2.ele) {
				return 1;
			}
			else if(p1.ele == p2.ele) {
				return p2.idx - p1.idx;
			}
			return -1;
		}
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		long k = sc.nextInt();
		
		long arr[] = new long[n];
//		int b_arr[] = new int[n];
		ArrayList<pair> al = new ArrayList<>();
		for(int i = 0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
//			b_arr[i] = i;
			al.add(new pair(arr[i] , i));
		}
		Collections.sort(al, new customSort());
//		Arrays.sort(b_arr, (i , j) -> {return (int) (arr[i] - arr[j]);});
		HashMap<Integer, Long> hm = new HashMap<Integer, Long>();
		for(int i=0 ; i<n-k ; i++) {
			hm.put(al.get(i).idx , hm.getOrDefault(al.get(i).idx , (long) 0) + 1);
		}
		long count = 0;
		long ans = 0;
		for(int i=0 ; i<arr.length ; i++) {
			if(hm.containsKey(i) == false) {
				count++;
			}
			else {
				ans += arr[i] + count;
				hm.put(i, hm.get(i) - 1);
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
