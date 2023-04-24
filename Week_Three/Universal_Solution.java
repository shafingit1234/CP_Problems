package Week_Three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Universal_Solution {
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
		long r;
		long p;
		long s;
		pair(long r, long p, long s){
			this.r  = r;
			this.p = p;
			this.s = s;
		}
	}
	public static void findAnswer() {
		String str = sc.next();
		pair[] p = new pair[str.length()];
		long r = 0;
		long P = 0;
		long s = 0;
		long mx = -1;
		for(int i= str.length()-1 ; i>=0 ;i--) {
			if(str.charAt(i) == 'R') {
				r++;
			}
			else if(str.charAt(i) == 'P') {
				P++;
			}
			else {
				s++;
			}
			p[i] = new pair(r, P, s);
			mx = Math.max(r,Math.max(mx,Math.max(P, s)));
		}
		char ch = '$';
		if(mx == P) {
			ch = 'S';
		}
		else if(mx == r) {
			ch = 'P';
		}
		else {
			ch = 'R';
		}
		long count = 0;
		long count_two =0;
		StringBuilder sb = new StringBuilder("");
		StringBuilder sb_two = new StringBuilder("");
		
		for(int i=0 ; i<str.length() ; i++) {
			if(p[i].r >= p[i].s && p[i].r >= p[i].p) {
//				System.out.print("P");
				sb.append("P");
				if(str.charAt(i) == 'R') {
					count++;
				}
				
//				if()
			}
			else if(p[i].s >= p[i].r && p[i].s >= p[i].p){
//				System.out.print("R");
				sb.append("R");
				if(str.charAt(i) == 'S') {
					count++;
				}
			}
			else {
//				System.out.print("S");
				sb.append("S");
				if(str.charAt(i) == 'P') {
					count++;
				}
			}
			if(ch == 'R') {
				if(str.charAt(i) == 'S') {
					count_two++;
				}
			}
			else if(ch == 'P') {
				if(str.charAt(i) == 'R') {
					count_two++;
				}
			}
			else {
				if(str.charAt(i) == 'P') {
					count_two++;
				}
			}
			sb_two.append(ch);
		}
//		System.out.println();
		if(count_two > count) {
			System.out.println(sb_two.toString());
		}
		else {
			System.out.println(sb.toString());
		}
		
	}
	public static void findAnswerTwo() {
        String t = sc.next();
        int r = 0, s = 0, p = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch == 'R')
                r++;
            else if (ch == 'S')
                s++;
            else
                p++;
        }
        char ch = 'R';
        if (r >= s && r >= p) {
            ch = 'P';
        } else if (s >= r && s >= p) {
            ch = 'R';
        } else {
            ch = 'S';
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < t.length(); i++)
            ans.append(ch);
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
//			findAnswer();
			findAnswerTwo();
		}
	}
}
