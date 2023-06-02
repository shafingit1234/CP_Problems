package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class codeforces_268B {
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
	public static void findAnswer() {
		int p = sc.nextInt();
		int q = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		pair[] z = new pair[p];
		pair[] c = new pair[q];
		for(int i=0 ; i<p ; i++) {
//			z[i] = new pair(sc.nextInt() , sc.nextInt());
			z[i] = new pair(sc.nextInt() , sc.nextInt());
		}
		for(int i=0 ; i<q ; i++) {
			c[i] = new pair(sc.nextInt() , sc.nextInt());
		}
		int ans = 0;
		for(int k = l ; k<=r ; k++) {
			boolean check = false;
			for(int i=0 ; i<q ; i++) {
				int temp_a = c[i].a + k;
				int temp_b = c[i].b + k;
				for(int j = 0 ; j<p ; j++) {
					int start = z[j].a;
					int end = z[j].b;
					if((temp_a >= start && temp_a <= end) || (temp_b >= start && temp_a <= end)) {
						ans++;
						check = true;
						break;
					}
				}
				if(check == true) {
					break;
				}
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
