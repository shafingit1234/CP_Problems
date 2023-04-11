package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class T_Primes {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		int n = sc.nextInt();
		while(n-- > 0) {
			long num = sc.nextLong();
//			int temp = (int)squareRoot(num, 0);
			long temp = (long)Math.sqrt(num);
			if(temp*temp != num) {
				System.out.println("NO");
				continue;
			}
			if(isPrime(temp) == true) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
//			System.out.println();
		}
	}
	public static boolean isPrime(long n)
    {
        if (n <= 1)
            return false;
 
        // Check if n=2 or n=3
        if (n == 2 || n == 3)
            return true;
 
        // Check whether n is divisible by 2 or 3
        if (n % 2 == 0 || n % 3 == 0)
            return false;
 
        // Check from 5 to square root of n
        // Iterate i by (i+6)
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
 
        return true;
    }
	public static float squareRoot(int number, int precision)
    {
        int start = 0, end = number;
        int mid;
 
        // variable to store the answer
        double ans = 0.0;
 
        // for computing integral part
        // of square root of number
        while (start <= end) {
            mid = (start + end) / 2;
 
            if (mid * mid == number) {
                ans = mid;
                break;
            }
 
            // incrementing start if integral
            // part lies on right side of the mid
            if (mid * mid < number) {
                start = mid + 1;
                ans = mid;
            }
 
            // decrementing end if integral part
            // lies on the left side of the mid
            else {
                end = mid - 1;
            }
        }
 
        // For computing the fractional part
        // of square root upto given precision
        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while (ans * ans <= number) {
                ans += increment;
            }
 
            // loop terminates when ans * ans > number
            ans = ans - increment;
            increment = increment / 10;
        }
        return (float)ans;
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
