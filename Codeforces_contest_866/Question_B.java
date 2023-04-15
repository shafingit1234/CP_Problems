package Codeforces_contest_866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Question_B {
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
//		int n = sc.nextInt();
		String str = sc.next();
		long cnt_ones = 0;
		for(int i=0 ; i<str.length(); i++) {
			if(str.charAt(i) == '1') {
				cnt_ones++;
			}
		}
		if(cnt_ones == str.length()) {
			System.out.println(cnt_ones*cnt_ones);
			return ;
		}
		long ans = 0;
//		if(cnt_ones >= 1) {
//			ans= 1;
//		}
//		cnt_ones = 0;
//		if(str.charAt(0) == '1' && str.charAt(str.length()-1) == '1') {
//			long first = 0;
//			long second = 0;
//			int i = 0;
//			while(i < str.length()) {
//				if(str.charAt(i) == '0') {
//					break;
//				}
//				else {
//					first++;
//				}
//				i++;
//			}
//			i = str.length()-1;
//			while(i >= 0) {
//				if(str.charAt(i) == '0') {
//					break;
//				}
//				else {
//					first++;
//				}
//				i--;
//			}
//			ans = Math.max(ans ,  first*(second+1));
//		}
//		for(int i=0 ; i<str.length() ; i++) {
//			if(str.charAt(i) == '0') {
//				if(cnt_ones == 0) {
//					continue;
//				}
//				ans = Math.max(ans, (cnt_ones-1)*2);
//				cnt_ones = 0;
//			}
//			else {
//				cnt_ones++;
//			}
//		}
		cnt_ones = 0;
		long rev = 0;
		long i=0;
		long final_cnt = 0;
		long len = str.length();
		while(true) {
			if(str.charAt((int)(i%len)) == '1') {
				cnt_ones++;
			}
			else {
				final_cnt = Math.max(final_cnt, cnt_ones);
				cnt_ones = 0;
			}
			i++;
			rev++;
			if(rev >= len) {
				if(str.charAt((int)(i%len)) == '0'){
					break;
				}
			}
		}
		final_cnt = Math.max(final_cnt, cnt_ones);
		ans = ((final_cnt+1)*(final_cnt+1))/4;
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
	public static void main(String[] args) {
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
