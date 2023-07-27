package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Magic_Triplets {
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

	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		HashMap<Integer, Integer> hm = new HashMap<>();
		int mx = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			mx = Math.max(mx, arr[i]);
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}

		long ans = 0;
		Arrays.sort(arr);
//		int b_max = (int)Math.sqrt(mx / arr[i]);
		for(int key : hm.keySet()) {
			long count = hm.get(key);
			if(count >= 3) {
				ans += (count) * (count - 1) * (count - 2);
			}
			long b_max = (long)Math.sqrt(mx / key) + 1;
			for(long b = 2 ; b <= b_max; b++) {
				long ele_2 = key * b;
				long ele_3 = ele_2 * b;
				if(ele_3 > 1e6) {
					break;
				}
				if(hm.containsKey((int)ele_2) == false || hm.containsKey((int)ele_3) == false) {
					continue;
				}
				ans += (count) * (hm.get((int)ele_2) * hm.get((int)ele_3));
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
//		int tc = 1;
		while (tc-- > 0) {
			findAnswer();
		}
	}
}
