package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Special_Numbers {
	public static FastScanner sc = new FastScanner();
	public static long mod = (long) (1e9 + 7);

	public static Long modexp(Long a, Long b) {
		Long ans = (long) 1;
		while (b > 0) {
			if ((b & 1) != 0)// b%2!=0
			{
				ans = (ans * a) % mod;
			}
			a = (a * a) % mod;
			b = b >> 1;
		}
		return ans;
	}

	public static long pow(long a, long b) {
		long res = 1;
		while (b > 0) {
			if ((b & 1) == 0) {
				a = (a * a) % mod;
				b = b >> 1;
			} else {
				res = (res * a) % mod;
				b--;
			}
		}
		return res % mod;
	}

	public static void findAnswer() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		long ans = 0;
		if (k == 1) {
			System.out.println(1);
			return;
		}
		for (int i = 30; i >= 0; i--) {
			if (((1 << i) & k) > 0) {
				ans = (ans + pow(n, i) % mod) % mod;
			}
		}
		System.out.println(ans);
	}

	public static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
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
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

	}

	public static final Random random = new Random();

	public static void ruffleSort(int[] a) {
		int n = a.length;// shuffle, then sort
		for (int i = 0; i < n; i++) {
			int oi = random.nextInt(n), temp = a[oi];
			a[oi] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}

	public static void main(String[] args) {
		int tc = sc.nextInt();
//		int tc = ;
		while (tc-- > 0) {
			findAnswer();
		}
	}
}
