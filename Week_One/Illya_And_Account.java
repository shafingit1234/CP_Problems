package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Illya_And_Account {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		String str = sc.next();
		int start = 0;
		if(str.charAt(0) == '-') {
			start++;
		}
		else {
			System.out.println(str);
			return ;
		}
		String temp_one = str.substring(start, str.length()-1);
		String temp_two = str.substring(start, str.length()-2) + str.charAt(str.length()-1);
		String ans = temp_one;
		if(Long.parseLong(temp_one) > Long.parseLong(temp_two)) {
			ans = temp_two;
		}
//		System.out.println(ans);
		if(str.length() >= 3) {
			if(Long.parseLong(ans) != 0) {
				
				ans = "-" + ans;
			}
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
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
