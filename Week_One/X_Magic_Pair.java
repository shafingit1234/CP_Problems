package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class X_Magic_Pair {
//	public static Scanner sc= new Scanner(System.in);
	public static FastScanner sc = new FastScanner();
	public static boolean check(long a,long b,long x) {
		if(a < b) {
			long temp = a;
			a = b;
			b = temp;
		}
		if(a == x || b == x) {
			return true;
		}
		else if(a==0 || b == 0 ) {
			return false;
		}
		else {
			if(a - x > 0 && (a - x)%b == 0) {
				return true;
			}
			else {
				return check(b, a%b , x);
			}
		}
//		return false;
	}
	public static void findAnswer() {
//		int tc = sc.nextInt();
		long a = sc.nextLong();
		long b = sc.nextLong();
		long x = sc.nextLong();
		boolean val = (check(a , b , x));
		if(val) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
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
}
