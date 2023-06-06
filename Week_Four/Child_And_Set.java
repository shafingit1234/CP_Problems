package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Child_And_Set {
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
	public static int findFirstBitSet(int i) {
		int count = 0;
		while((i&1) != 1) {
			i = i>>1;
			count++;
		}
		return count;
	}
	public static void findAnswer() {
		long sum = sc.nextLong();
		int limit = sc.nextInt();
		long lowbit[] = new long[(int)1e6];
		lowbit[0] = -1;
		for(int i=1 ; i<lowbit.length ; i++) {
			lowbit[i] = (1<<findFirstBitSet(i));
		}
		int ans = 0;
		ArrayList<Integer> hs = new ArrayList<>();
		for(int i= limit ; i>=0 ; i--) {
			long temp = lowbit[i];
			if(sum >= lowbit[i]) {
//				System.out.println(sum + " " + lowbit[i]);
				sum -= lowbit[i];
				hs.add(i);
				if(sum == 0) {
					break;
				}
			}
			
		}
		Collections.sort(hs);
		if(sum == 0) {
			System.out.println(hs.size());
			for(int i : hs) {
				System.out.print(i + " ");
			}
			return ;
		}
		System.out.println(-1);
//		System.out.println(findFirstBitSet(4));
	}
	private static int lowbit(int i) {
		// TODO Auto-generated method stub
		return 0;
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
