package Week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Pull_Your_Luck {
	public static FastScanner sc = new FastScanner();
	public static long mod = (long)(1e9 + 7);
	public static Long modexp(Long a,Long b)
    { Long ans=(long)1;
        while(b>0)
        {
          if((b&1)!=0)// b%2!=0
          {
              ans=(ans*a)%mod;
          }
          a=(a*a)%mod;
          b=b>>1;  
        }
        return ans;
    }
	public static void findAnswer() {
		long n = sc.nextLong();
		long x = sc.nextLong();
		long p = sc.nextLong();
		
//		int needed = (n - x)%n;
		long i = 0;
		boolean check = false;
		for(i = 1 ; i<=Math.min(2*n , p) ; i++) {
			//1 2 3 4 5
			long temp = (i * (i + 1))/2;
//			temp = temp%n;
//			if(i == 77300) {
//				System.out.println(i * (i + 1)/2);
//			}
			if((x + temp)%n == 0) {
//				System.out.println(i);
//				System.out.println(temp);
//				System.out.println(x + temp);
				check = true;
				break;
			}
		}
//		System.out.println(i);
		if(check == true) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
//		if(i > Math.min(2*n, p)) {
//		77300
//		840200002
//			System.out.println("NO");
//		}
//		System.out.println("YES");
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
