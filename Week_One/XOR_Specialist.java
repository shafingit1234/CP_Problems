package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class XOR_Specialist {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		if(n%2 == 0) {
			System.out.println("YES");
			return ;
		}
		else {
//			boolean check = true;
			for(int i=0 ;i < n-1 ; i++) {
				if(arr[i] >= arr[i+1]) {
//					check = false;
//					break;
					System.out.println("YES");
					return ;
				}
			}
		}
		System.out.println("NO");
		return ;
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
