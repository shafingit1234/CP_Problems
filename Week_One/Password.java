package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Password {
	public static long dp[] ;
	public static long dp_one[];
	public static long dp_two[];
	public static long power_one[] ;
	public static long power_two[];
	public static long mod_one = 1000003;
	public static long mod_two = 1000000007;
	public static long prime_one = 31;
	public static long prime_two = 39;
	public static long bigamod = 100549567L;
	public static FastScanner sc = new FastScanner();
	public static void preProcess(String s) {
		int n = s.length();
		dp_one = new long[n];
		dp_two = new long[n];
		power_one = new long[n];
		power_two = new long[n];
//		long prime = 31;
		long pow = prime_one;
		dp_one[0] = s.charAt(0) - 'a' + 1;
		power_one[0] = 1;
		for(int i=1 ; i<n ; i++) {
			dp_one[i] = ((dp_one[i-1]) + (s.charAt(i) - 'a' + 1)*pow%mod_one)%mod_one;
			power_one[i] = pow;
			pow = (pow*prime_one)%mod_one;
		}
		
		power_two[0] = 1;
		pow = prime_two;
		dp_two[0] = s.charAt(0) - 'a' + 1;
		for(int i=1 ; i<n ; i++) {
			dp_two[i] = ((dp_two[i-1]) + (s.charAt(i) - 'a' + 1)*pow%mod_two)%mod_two;
			power_two[i] = pow;
			pow = (pow*prime_two)%mod_two;
		}
	}
	public static long findHash(int l, int r) {
		long ans = dp_one[r];
		if(l > 0) {
			ans = (ans - dp_one[l-1] + mod_one)%mod_one;
		}
		return ans;
	}
	public static long findHashTwo(int l, int r) {
		long ans = dp_two[r];
		if(l > 0) {
			ans = (ans - dp_two[l-1] + mod_two)%mod_two;
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
			long pref_one = dp_one[i];
			long pref_two = dp_two[i];
			long suff_two = findHashTwo(n-i-1 , n-1);
			long suff_one = findHash(n-i-1 , n-1);
//			long suff = findHash(n-i-1 , n-1);
			if((pref_one*power_one[n-i-1])%mod_one == suff_one && (pref_two*power_two[n-i-1])%mod_two == suff_two) {
				for(int j =1 , k=i+1 ; k<n-1 ; j++,k++) {
					long mid_one = findHash(j , k);
					long mid_two = findHashTwo(j , k);
					if((pref_one*power_one[j])%mod_one == mid_one && (pref_two*power_two[j])%mod_two == mid_two) {
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
