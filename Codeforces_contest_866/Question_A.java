package Codeforces_contest_866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Question_A {
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
		String str = sc.next();
		String smile_one = "^_^";
		String smile_two = "^^";
		long ans = 0;
		for(int i=0 ; i<str.length(); i++) {
			if(i + 3 <= str.length()){
//				System.out.println(i + " " + str.substring(i , i+3));
				if(str.substring(i , i+3).equals(smile_one) == true) {
					
					i+=1;
					if(i+1 == str.length() - 1) {
						break;
					}
					continue;
				}
			}
			if(i + 2 <= str.length()) {
				if(str.substring(i , i+2).equals(smile_two) == true) {
//					i+=1;
					if(i + 1 == str.length()- 1) {
						break;
					}
					continue;
				}
			}
			//find number of dashes present ahead of ^
			int start = i;
//			System.out.print(start + " ");
			boolean check = true;
			if(str.charAt(i) == '^') {
				start++;
				check = false;
			}
			int count = 0;
			while(start < str.length()) {
//				if()
				if(str.charAt(start) == '^') {
					break;
				}
				count++;
//				i++;
				start++;
			}
//			System.out.println(start+ " " + count);
			if(count == 0) {
				ans++;
			}
			else {
				if(start >= str.length()) {
					ans++;
				}
				if(check == true) {
					ans++;
				}
				ans+= count - 1;
			}
//			System.out.println(start+ " " + count + " " + ans);
			if(start >= str.length()-1) {
				break;
			}
			i = start-1;
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
	public static void main(String[] args) {
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
