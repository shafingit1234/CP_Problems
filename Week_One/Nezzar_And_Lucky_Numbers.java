package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Nezzar_And_Lucky_Numbers {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		int q= sc.nextInt();
		int d = sc.nextInt();
		for(int i=0 ; i<q ;i++) {
			long temp = sc.nextLong();
			if(check(temp ,d) == true) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	public static boolean checkDig(long rem, int dig) {
		while(rem > 0) {
			int rem_dig = (int)rem%10;
			rem = rem/10;
			if(rem_dig == dig) {
				return true;
			}
		}
		return false;
	}
	public static boolean check(long num, int dig) {
		long cnt = (num/dig);
		long rem = (num%dig);
		while(cnt > 0) {
			cnt--;
			rem += dig;
			if(checkDig(rem , dig) == true) {
				return true;
//				break;
			}
			
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
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
