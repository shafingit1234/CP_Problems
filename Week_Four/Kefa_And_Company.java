package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Kefa_And_Company {
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
		long a;
		long b;
		pair(long a, long b){
			this.a = a;
			this.b = b;
		}
	}
	public static class customSort implements Comparator<pair>{

		@Override
		public int compare(pair p0, pair p1) {
			if(p1.a > p0.a) {
				return -1;
			}
			else if(p1.a == p0.a) {
				return 0;
			}
			return 1;
		}
		
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		long d = sc.nextLong();
		
		ArrayList<pair> al = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			pair p = new pair(sc.nextLong() , sc.nextLong());
			al.add(p);
		}
		Collections.sort(al , new customSort());
		long current_factor = 0;
		long ans = 0;
		int start = 0;
		int tmp_start = 0;
		while(start < al.size()) {
			long temp_factor = al.get(start).b;
			long value = al.get(start).a;
			long diff = value - al.get(tmp_start).a;
			if(diff < d) {
				current_factor += temp_factor;
//				System.out.println(current_factor);
				ans = Math.max(ans, current_factor);
			}
			else {
				while(tmp_start < start && (value - al.get(tmp_start).a) >= d) {
					current_factor -= al.get(tmp_start).b;
//					System.out.println(current_factor);
					tmp_start++;
				}
				start--;
			}
			start++;
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
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
