package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Perfect_Number {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		int x = sc.nextInt();
		int cnt = 0;
		int start  =19;
		while(cnt < x) {
			if(check(start) == true) {
				cnt++;
			}
			if(cnt == x) break;
			start += 9;
		}
		System.out.println(start);
	}
	public static boolean check(int num) {
		int sum = 0;
		while(num > 0) {
			sum += num%10;
			num = num/10;
		}
		if(sum == 10) {
			return true;
		}
		return false;
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
