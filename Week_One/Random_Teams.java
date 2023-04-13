package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Random_Teams {
	public static FastScanner sc = new FastScanner();
	public static long findNcr(long a) {
		
		return ((a)*(a-1))/2;
	}
	public static void findAnswer() {
		long n = sc.nextLong();
		long m = sc.nextLong();
		long mn = 0;
		long mx = 0;
		mx = findNcr(n - (m-1));
//		if(n%m == 0) {
//			mn = findNcr((n/m))*(m);
//		}
//		else {
//			mn = findNcr((n/m))*(m-1) + findNcr((n/m) + (n%m));
			long q = (n/m);
			long r = n%m;
			mn = (findNcr(q)*(m - r)) + (findNcr((q) + 1)*(r));
//		}
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
		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
