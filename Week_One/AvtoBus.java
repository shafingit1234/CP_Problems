package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class AvtoBus {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		long n = sc.nextLong();
		if(n%2 != 0) {
			System.out.println(-1);
			return ;
		}
		n /= 2;
//		FINDING MAXIMUM
		long mx = -1;
		long mn = -1;
		if(n%2 == 0) {
			mx = n/2;
		}
		else if(n%2 != 0) {
			if(n - 3 >= 0) {
				mx = 1 + (n-3)/2;
			}
		}
		if(n%3 == 0) {
			mn = n/3;
		}
		else if(n%3 != 0) {
			if(n%3 == 1) {
				if(n - 4 >= 0) {
					mn = 2 + (n-4)/3;
				}
			}
			else if(n%3 == 2) {
				if(n - 2 >= 0) {
					mn = 1 + (n-2)/3;
				}
			}
		}
		if(mn == -1 && mx == -1) {
			System.out.println(-1);
			return ;
		}
		else if(mn == -1 || mx == -1) {
			if(mn == -1) mn = mx;
			else if(mx == -1) mx=mn;
		}
		System.out.println(mn + " " + mx);
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
