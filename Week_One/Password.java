package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Password {
	public static long dp[] ;
	public static long power[] ;
	public static long mod = 1000000007;
	public static long bigamod = 100549567L;
	public static FastScanner sc = new FastScanner();
	public static void preProcess(String s) {
		int n = s.length();
		dp = new long[n];
		power = new long[n];
		long prime = 947;
		long pow = prime;
		dp[0] = s.charAt(0) - 'a' + 1;
		power[0] = 1;
		for(int i=1 ; i<n ; i++) {
			dp[i] = (dp[i-1]) + (s.charAt(i) - 'a' + 1)*pow%bigamod;
			power[i] = pow;
			pow = (pow*prime)%bigamod;
		}
		
	}
	public static long findHash(int l, int r) {
		long ans = dp[r];
		if(l > 0) {
			ans = (ans - dp[l-1] + bigamod)%bigamod;
		}
		return ans;
	}
	public static void findAnswer() {
		String s = sc.next();
//		long dp[] = new long[s.length()];
//		long power[] = new long[n];
		preProcess(s);
		int n = s.length();
//		consider prefixs and suffixes, compare there hash values,
//		then search for same prefix string in the mid,if there is a match in hash values.
		int ans = 0;
		for(int i=0 ; i<n-1 ; i++) {
			long pref = dp[i];
			long suff = findHash(n-i-1 , n-1);
			if((pref*power[n-i-1])%bigamod == suff) {
				for(int j =1 , k=i+1 ; k<n-1 ; j++,k++) {
					long mid = findHash(j , k);
					if((pref*power[j])%bigamod == mid) {
//						ans = Math.max(ans, i+1);
						ans = i+1;
						break;
					}
				}
			}
		}
		if(ans == 0) {
			System.out.println("Just a legend");
		}
		else {
			System.out.println(s.substring( 0 ,ans));
		}
	}
	public static void findAnswerTwo() {
		String str = sc.next();
		int dp[] = new int[str.length()];
		int k=1 ; 
		int len = 0;
		while(k<str.length()) {
			if(str.charAt(k) == str.charAt(len)) {
				len++;
				dp[k] = len;
				k++;
			}
			else {
				if(len > 0) {
					len = dp[len-1];
				}
				else {
					dp[k] = 0;
					k++;
				}
			}
		}
		if(dp[str.length()-1] == 0) {
			System.out.println("Just a legend");
			return ;
		}
		boolean found = false;
		for(int i=0 ; i<str.length()-1; i++) {
			if(dp[i] == dp[str.length()-1]) {
				found = true;
			}
		}
		if(found) {
			System.out.println(str.substring(0,dp[str.length()-1]));
		}
		else {
			int c=dp[dp[str.length()-1]-1];
      	  //. System.out.println(dp[6]-1);
      	   if(c>0) {
      		   System.out.println(str.substring(0,c));
      	   }else {
      		   System.out.println("Just a legend");
      	   }
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
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
