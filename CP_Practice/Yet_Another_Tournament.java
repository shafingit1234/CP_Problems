package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Yet_Another_Tournament {
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

	public static void justforfun() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=1 ; i<10000 ; i++) {
			int count = printDivisors(i);
			if(count%2 != 0) {
				al.add(i);
			}
		}
		for(int i : al) {
			System.out.println(i);
		}

	}

	public static int printDivisors(int n) {
		// Note that this loop runs till square root
		int count = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			
			if (n % i == 0) {
				// If divisors are equal, print only one
				if (n / i == i)
					count++;
					

				else 
					count+= 2;
			}
		}
		return count;
	}

	public static void findAnswer() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int[] b_arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			b_arr[i] = arr[i];
		}
		Arrays.sort(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int sum = 0;
		int wins = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sum + arr[i] <= m) {
				sum += arr[i];
				wins++;
				pq.offer(arr[i]);
			}
		}
//		System.out.println(wins);
		if (wins == n) {
			System.out.println(1);
			return;
		}
		if (pq.isEmpty() == true) {
			System.out.println(n + 1);
			return;
		}
		int temp = pq.poll();
		int pos = n - wins;
		if (sum - temp + b_arr[wins] > m)
			pos++;
		System.out.println(pos);
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
//			justforfun();
		}
	}
}
