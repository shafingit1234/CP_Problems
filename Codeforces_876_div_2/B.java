package Codeforces_876_div_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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
	public static class pair{
		int a;
		int b;
		pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	public static class customSort implements Comparator<pair>{
		public int compare(pair p1, pair p2){
			if(p1.a > p2.a) {
				return 1;
			}
			else if(p1.a == p2.a) {
				if(p2.b > p1.b) {
					return 1;
				}
				return -1;
			}
			return -1;
//			return 1;
			
		}
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		ArrayList<pair> al = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			al.add(new pair(a, b));
		}
		Collections.sort(al , new customSort());
		System.out.println();
		for(pair p : al) {
			System.out.println(p.a + " " + p.b);
		}
		int x = 0;
		long ans = 0;
		int start = 0;
//		HashSet<Integer> hs = new HashSet<>(); 
//		HashSet<Integer> broken = new HashSet<>();
		for(int i=0 ; i<al.size(); i++) {
//			if(broken.contains(i) == true) {
//				continue;
//			}
			ans += al.get(i).b;
			x++;
			if(al.get(start).a > x) {
				continue;
			}
			while(start < al.size() && al.get(start).a <= x) {
//				hs.add(al.get(start).a);
//				broken.add(start);
				start++;
			}
			x -= (start - i) + 1;
			if(x < 0) x = 0;
			if(start > i) {
				i = start-1;
			}
//			hs.clear();
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
