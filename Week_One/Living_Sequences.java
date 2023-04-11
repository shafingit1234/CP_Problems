package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Living_Sequences {
	
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		long t = sc.nextLong();
//		convert into 9 base numerical format.
		StringBuilder sb = new StringBuilder("");
		while(t > 0) {
			sb.append(t%9);
			t = t/9;
		}
		for(int i=sb.length()-1 ; i>=0 ; i--) {
			int dig = Integer.parseInt(sb.charAt(i) + "");
			if(dig >= 4) {
				System.out.print(dig + 1);
			}
			else {
				System.out.print(dig);
			}
		}
//		return ;
		System.out.println();
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
