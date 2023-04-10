package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Odd_Queries {
	public static Scanner sc = new Scanner(System.in);
	public static FastScanner new_sc = new FastScanner();
	PrintWriter out = new PrintWriter(System.out);
	public static void findAnswer() {
		int n = new_sc.nextInt();
		int q = new_sc.nextInt();
		int prefix[] = new int[n+1];
		prefix[0] = 0;
		for(int i=1 ; i<=n ;i++) {
			prefix[i] = new_sc.nextInt() + prefix[i-1];
		}
		while(q-- > 0) {
			int l = new_sc.nextInt();
			int r = new_sc.nextInt();
			int k = new_sc.nextInt();
			int sum = prefix[n];
//			System.out.println();
			int temp = sum - prefix[r] + prefix[l-1] + k*(r-l + 1);
			if(temp%2 == 0) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
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
		int tc = new_sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
