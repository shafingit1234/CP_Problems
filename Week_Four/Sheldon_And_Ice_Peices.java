package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Sheldon_And_Ice_Peices {
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
		char[] str = sc.next().toCharArray();
		char[] seq = sc.next().toCharArray();
		long [] freq_str = new long[10];
		long [] freq_seq = new long[10];
		for(int i=0; i<str.length ; i++) {
			if(str[i] == '5') {
				str[i] = '2';
			}
			if(str[i] == '9') {
				str[i] = '6';
			}
			freq_str[str[i] - '0']++;
		}
		for(int i=0 ; i<seq.length ; i++) {
			if(seq[i] == '5') {
				seq[i] = '2';
			}
			if(seq[i] == '9') {
				seq[i] = '6';
			}
			freq_seq[seq[i] - '0']++; 
		}
		long ans = Integer.MAX_VALUE;
		for(int i=0 ; i<=9 ; i++) {
			if(freq_str[i]!=0) {
				ans = Math.min(ans, (freq_seq[i]/freq_str[i]));
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
		}
	}
}
