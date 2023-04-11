package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Ian_Visits_Marry {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		int temp = gcd(x, y);
		if(temp == 1) {
			System.out.println(1);
			System.out.println(x + " " + y);
			return;
		}
		else {
			System.out.println(2);
			System.out.println(1 + " " + (y-1));
			System.out.println(x + " " + y);
			return ;
		}
	}
	public static int gcd(int a, int b) {
		if (b == 0)
	        return a;
	    else
	        return gcd (b, a % b);
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
