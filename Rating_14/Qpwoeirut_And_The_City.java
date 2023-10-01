package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Qpwoeirut_And_The_City {
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
		long h[] = new long[n];
		int cool_count = 0;
		for(int i=0 ; i<n ; i++) {
			h[i] = sc.nextLong();
		}
		HashSet<Integer> cool = new HashSet<>();
		for(int i=0 ; i<n ; i++) {
			if(i != 0 && i != n-1) {
				if(h[i] > h[i-1] && h[i] > h[i+1]) {
					cool_count++;
					cool.add(i);
				}
			}
		}
		long bricks_needed = 0;
		long ans = Long.MAX_VALUE;
		int new_count = 0;
		int max_count = cool_count;
		for(int i=1 ; i<n ; i+=2) {
			if(i == n-1) continue;
			if(cool.contains(i-1) == false && cool.contains(i+1) == false && (h[i] <= h[i-1] || h[i] <= h[i+1])) {
				long temp = 0;
				if(h[i] + temp <= h[i-1]) {
					temp = h[i-1] - h[1] + 1;
					bricks_needed += h[i-1] - h[i] + 1;
					
				}
				if(h[i] + temp <= h[i+1]) {
					bricks_needed += h[i+1] - h[i] + 1;
				}
				new_count++;
			}
		}
		if(new_count != 0) {
			ans = Math.min(ans, bricks_needed);			
		}
		max_count = Math.max(new_count + cool_count, cool_count);
		bricks_needed = 0;
		new_count = 0;
		for(int i = 2 ; i<n ; i+=2) {
			if(i == n-1) continue;
			if(cool.contains(i-1) == false && cool.contains(i+1) == false && (h[i] <= h[i-1] || h[i] <= h[i+1])) {
				long temp = 0;
				if(h[i] + temp <= h[i-1]) {
					temp = h[i-1] - h[1] + 1;
					bricks_needed += h[i-1] - h[i] + 1;
				}
				if(h[i] + temp <= h[i+1]) {
					bricks_needed += h[i+1] - h[i] + 1;
				}
				new_count++;
			}
		}
		if(max_count <= cool_count + new_count) {
			ans = Math.min(ans, bricks_needed);			
		}
		if(ans == Long.MAX_VALUE) {
			ans = 0;
		}
		System.out.println(ans);
	}
	public static class pair{
		long ele;
		int  count;
		pair(long ele, int count){
			this.ele = ele;
			this.count = count;
		}
	}
	public static pair recurse(long[] h , int idx, int temp_count,HashSet<Integer> cool ) {
		if(idx >= h.length - 1) {
			if(cool.size() > temp_count) {
				long ans = 0;
				for(int j : cool) {
					long temp = 0;
					if(h[j] <= h[j-1]) {
						temp += h[j-1] - h[j] + 1;
					}
					if(h[j] + temp <= h[j+1]) {
						temp += h[j+1] - h[j] + 1;
					}
					ans += temp;
				}
				
				return new pair(ans , cool.size());
			}
			return new pair(Long.MAX_VALUE , temp_count);
		}
		if(idx==0) {
			return recurse(h, idx+1, temp_count, cool);
		}
		if(h[idx] > h[idx-1] && h[idx] > h[idx + 1]) {
			cool.add(idx);
			pair sp1 = recurse(h , idx+1, temp_count , cool);
			
			cool.remove(idx);
			return sp1;
		}
		else {
			boolean flag = true;
			if(cool.contains(idx-1) == true) {
				cool.remove(idx-1);
				flag = false;
			}
			cool.add(idx);
			pair sp1 = recurse(h, idx+1, temp_count, cool);
			cool.remove(idx);
			if(flag == false) {
				flag = true;
				cool.add(idx-1);
			}
			pair sp3 = recurse(h, idx+1, temp_count, cool);
//			return Math.min(sp1,sp3);
			int c = Math.max(sp1.count,  sp3.count);
			if(c <= temp_count) {
				return new pair(Long.MAX_VALUE , temp_count);
			}
			if(sp1.count > sp3.count) {
				return sp1;
			}
			else if(sp1.count == sp3.count) {
				if(sp1.ele < sp3.ele) {
					return sp1;
				}
			}
			return sp3;
		}
	}
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		long h[] = new long[n];
		for(int i =0 ; i<n ; i++) {
			h[i] = sc.nextLong();
		}
		int cool_count = 0;
		HashSet<Integer> cool = new HashSet<>();
		for(int i=0 ; i<n ; i++) {
			if(i != 0 && i != n-1) {
				if(h[i] > h[i-1] && h[i] > h[i+1]) {
					cool_count++;
				}
			}
		}
		pair ans = recurse(h , 0, cool_count, cool);
		long res = 0;
		if(ans.ele != Long.MAX_VALUE) {
			res = ans.ele;
		}
		System.out.println(res);
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
//			findAnswer();
			findAnswerTwo();
		}
	}
}
