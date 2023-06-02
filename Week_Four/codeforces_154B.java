package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class codeforces_154B {
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

	public static int colliders[];
	public static int factors[];
	public static Scanner sb = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int requests = sc.nextInt();
		colliders = new int[n + 1];
		factors = new int[n + 1];
		while (requests > 0) {
			requests--;
			char ch = sc.next().charAt(0);
			int num = sc.nextInt();
			if (ch == '-') {
				if (colliders[num] == 0) {
					System.out.println("Already off");
					continue;
				}
			} else if (ch == '+') {
				if (colliders[num] == 1) {
					System.out.println("Already on");
					continue;
				}
			}
			// store possible factors of num.
			ArrayList<Integer> al = new ArrayList<Integer>();
			int temp = num;
			for (int i = 2; i*i<= temp; i++) {
				if (temp % i == 0) {
					al.add(i);
				}
				while(temp%i == 0) {
					temp = temp/i;
				}
			}
			if(temp > 1) {
				al.add(temp);
			}
			if (ch == '+') {
				boolean check = false;
				for (int i : al) {
					if (factors[i] != 0) {
						check = true;
						System.out.println("Conflict with " + factors[i]);
						break;
					}
				}
				if (check == false) {
					// no conflict, chance of success
					for (int i : al) {
						factors[i] = num;
					}
					colliders[num] = 1;
					System.out.println("Success");
				}
			}
			if(ch == '-') {
				colliders[num] = 0;
				for(int i : al) {
					factors[i] = 0;
				}
				System.out.println("Success");
			}
		}
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
//		int tc = sc.nextInt();
		int tc = 1;
		while (tc-- > 0) {
			findAnswer();
		}
	}
}
