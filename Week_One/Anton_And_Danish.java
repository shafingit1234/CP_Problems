package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Anton_And_Danish {
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
			String str= sc.next();
			int cnt_a = 0;
			int cnt_d = 0;
			for(int i=0 ; i<n ;i++) {
				if(str.charAt(i) == 'A') {
					cnt_a++;
				}
				else {
					cnt_d++;
				}
			}
			if(cnt_a > cnt_d) {
				System.out.println("Anton");
				return ;
			}
			else if(cnt_a < cnt_d){
				System.out.println("Danik");
			}
			else {
				System.out.println("Friendship");
			}
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
		public static void main(String[] args) {
//			int tc = sc.nextInt();
			int tc = 1;
			while(tc-- > 0) {
				findAnswer();
			}
		}
}
