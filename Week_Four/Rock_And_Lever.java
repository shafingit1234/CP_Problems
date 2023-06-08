package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Rock_And_Lever {
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
	public static int findHighestSetBit(int num) {
		int ans = 0;
		for(int j=31 ; j>=0 ; j--) {
			if(((1<<j)&num) > 0) {
				ans = j;
				break;
			}
		}
		return ans;
	}
	public static int factorial[];
	public static void computeFactorial() {
		factorial = new int[(int)1e5];
		factorial[1] = 1;
		for(int i=2 ; i<factorial.length ; i++) {
			factorial[i] = i*factorial[i-1];
		}
	}
	public static long computeSum(int size) {
		long ans = 0;
		size--;
		while(size >= 0) {
			ans += size--;
			ans = ans%mod;
		}
		return ans;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0 ; i<n ; i++) {
			int idx = findHighestSetBit(arr[i]);
			if(hm.containsKey(idx) == false) {
				hm.put(idx , 0);
			}
			hm.put(idx , hm.get(idx) + 1);
		}
		long ans = 0;
//		computeFactorial();
		for(int i=0 ; i<=31 ; i++) {
			if(hm.containsKey(i) == true && hm.get(i) >= 2) {
				int sze = hm.get(i);
				ans += ((long)sze * (sze-1))/2;
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
