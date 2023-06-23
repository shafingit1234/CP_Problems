package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Bracket_Coloring {
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
		int size = sc.nextInt();
		String str = sc.next();
		int bal[] = new int[size + 1];
		for(int i=0 ; i<size ; i++) {
			if(str.charAt(i) == '(') {
				bal[i+1] = bal[i]+1;
			}
			else {
				bal[i+1] = bal[i] - 1;
			}
		}
		int mx = Integer.MIN_VALUE;
		int mn = Integer.MAX_VALUE;
		for(int i=0 ; i<bal.length ; i++) {
			mx = Math.max(mx, bal[i]);
			mn = Math.min(mn,  bal[i]);
		}
		if(bal[size] != 0) {
			System.out.println(-1);
			return ;
		}
		else {
//			find out whether 0 is maximum or minimum element as balance. which means string is regularly balanced, could use a stack too.
			if(mx == 0 || mn == 0) {
				System.out.println(1);
				for(int i=0 ; i<str.length() ; i++) {
					System.out.print(1 + " ");
				}
			}
			else {
				System.out.println(2);
				for(int i=0 ; i<str.length() ; i++) {
					int dig = (str.charAt(i) == '(' ? 1 : 2);
					int curr = i;
					while(bal[curr+1] != 0) {
						System.out.print(dig + " ");
						curr++;
					}
					System.out.print(dig + " ");
					i = curr;
				}
			}
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
