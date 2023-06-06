package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class codeforces_742B {
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
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		int x  =sc.nextInt();
		int[] a = new int[n];
		int freq[] = new int[(int)1e6];
		int ans = 0;
		for(int i=0 ; i<n ; i++) {
			a[i] = sc.nextInt();
			ans += freq[a[i]^x];
			freq[a[i]]++;
		}
		System.out.println(ans);
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int x = sc.nextInt();
		int [] a = new int[n];
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		for(int i=0 ; i<n ; i++) {
			a[i] = sc.nextInt();
//			hm.compute(, arg1)
			if(hm.containsKey(a[i]) == false) {
				hm.put(a[i] , new ArrayList<Integer>());
			}
			hm.get(a[i]).add(i);
		}
		long ans = 0;
		for(int i=0 ; i<n ; i++) {
			int temp = a[i] ^ x;
			if(hm.containsKey(temp) == true) {
				ArrayList<Integer> tmp = hm.get(temp);
				int start = 0;
				int end = tmp.size()-1;
				while(start <= end) {
					int mid = start + (end - start)/2;
					if(tmp.get(mid) <= i) {
						start = mid+1;
					}
					else {
						end = mid-1;
					}
				}
				end++;
				if(end >= n) {
					continue;
				}
				ans += tmp.size() - end;
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
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
//			findAnswerTwo();
		}
	}
}
