package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Arranging_The_Sheep {
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
		int len = sc.nextInt();
		String str = sc.next();
		if(len == 1) {
//			return 0;
			System.out.println(0);
			return ;
		}
		long sheep_front[] = new long[str.length() + 1];
		long sheep_back[] = new long[str.length() + 1];
		long moves_front[] = new long[str.length() + 1];
		long moves_back[] = new long[str.length() + 1];
//		int len = str.length();
		for(int i = 0 ; i<len ; i++) {
			char ch = str.charAt(i);
			if(i == 0) {
				if(ch == '*') {
					sheep_front[i]++;
				}
			}
			else {
				if(ch == '*') {
					sheep_front[i] = sheep_front[i-1] + 1;
					moves_front[i] = moves_front[i-1];
				}
				else {
					sheep_front[i] = sheep_front[i-1];
					moves_front[i] = moves_front[i-1] + sheep_front[i];
				}
			}
		}
		for(int i = len-1 ; i>=0 ; i--) {
			char ch = str.charAt(i);
			if(i == len-1) {
				if(ch == '*') {
					sheep_back[i]++;
				}
			}
			else {
				if(ch == '*') {
					sheep_back[i] = sheep_back[i+1] + 1;
					moves_back[i] = moves_back[i+1];
				}
				else {
					sheep_back[i] = sheep_back[i+1];
					moves_back[i] = moves_back[i+1] + sheep_back[i];
				}
			}
		}
		long ans = Long.MAX_VALUE;
		long possible_moves[] = new long[len + 1];
		for(int i = 0 ; i<len ; i++) {
			char ch = str.charAt(i);
			if(ch == '*') {
				possible_moves[i] = moves_front[i] + moves_back[i];
			}
			else {
				long sp1 = Long.MAX_VALUE;
				long sp2 = Long.MAX_VALUE;
				if(i+1 < len) {
					sp1 = moves_back[i+1] + moves_front[i];
				}
				if(i-1 >= 0) {
					sp2 = moves_back[i] + moves_front[i-1];
				}
				possible_moves[i] = Math.min(sp1, sp2);	
				
			}
			ans = Math.min(ans,  possible_moves[i]);
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
