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

public class Tear_It_Part {
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
		String str = sc.next();
		HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
		for(int i=0 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			if(hm.containsKey(ch) == false) {
				hm.put(ch , new ArrayList<Integer>());
			}
			hm.get(ch).add(i);
		}
		long ans = Integer.MAX_VALUE;
		for(char ch : hm.keySet()) {
			ArrayList<Integer> temp = hm.get(ch);
			long oddSum = 0;
			long evenSum = 0;
			long diff = temp.get(0) - 0;
			if(diff%2 == 0) {
				evenSum += diff;
			}
			else {
				oddSum += diff;
			}
			diff = str.length()- temp.get(temp.size() - 1) - 1;
			if(diff%2 == 0) {
				evenSum += diff;
			}
			else {
				oddSum += diff;
			}
			for(int i = 0 ; i < temp.size()-1; i++) {
				diff = temp.get(i+1) - temp.get(i) - 1;
				if(diff%2 == 0) {
					evenSum += diff;
				}
				else {
					oddSum += diff;
				}
			}
			diff = evenSum + oddSum;
//			System.out.println(ch + " " + diff);
			long sum = 0;
			while(diff > 0) {
				diff = diff/2;
				sum++;
			}
			ans = Math.min(ans,  sum);
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
