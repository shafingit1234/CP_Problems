package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Nitika_and_Strings {
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

	public static class pair {
		int a;
		int b;

		pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	public static void findAnswerTwo() {
		String str = sc.next();
		int n = str.length();
		int prefa[] = new int[n+1];
		int prefb[] = new int[n+1];
//		if(str.charAt(0) == 'a') {
//			prefa[0] = 1;
////			prefb[0] = 1;
//		}
//		else {
//			prefb[0] = 1;
//		}
		for(int i=1 ; i<=n ; i++) {
			if(str.charAt(i-1) == 'a') {
				prefa[i] = prefa[i-1] + 1;
			}
			else {
				prefb[i] = prefb[i-1] + 1;
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i=0 ;i<n ; i++) {
			for(int j = i ; j<=n ; j++) {
				ans = Math.max(ans,  prefa[i] + (prefb[j] - prefb[i]) + prefa[n] - prefa[j]);
			}
		}
		System.out.println(ans);
	}
	public static void findAnswer() {
		String str = sc.next();
		int ans = Integer.MIN_VALUE;
//		System.out.println(str.length());
		ArrayList<pair> al = new ArrayList<>();
		int count_a = 0;
		int count_b = 0;
		al.add(new pair(0, 0));
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				count_a++;
			} else {
				count_b++;
			}
			al.add(new pair(count_a, count_b));
		}
//		int deletes_a = 0;
//		int deletes_b = 0;
		for (int i = 0; i < str.length()-2; i++) {
			int deletes_a = 0;
			int deletes_b = 0;
			pair p_one = al.get(i + 1);
			p_one.a = p_one.a - al.get(0).a;
			p_one.b = p_one.b - al.get(0).b;
			System.out.println(p_one.a + " " + p_one.b);
			System.out.println("=========");
			if (p_one.b != 0) {
				deletes_b += p_one.b;
			}
			for (int j = i + 1; j < str.length()-1; j++) {
				pair p_two = al.get(j+1);
				p_two.a = Math.abs(p_two.a - al.get(i+1).a);
				p_two.b = Math.abs(p_two.b - al.get(i+1).b);
				System.out.println("two " + p_two.a + " " + p_two.b);
				int temp_a = deletes_a ;
				int temp_b = deletes_b ;
				if(p_two.a != 0) {
					deletes_a += p_two.a;
				}
				pair p_three = al.get(al.size() - 1);
				p_three.a = Math.abs(p_three.a - al.get(j+1).a);
				p_three.b = Math.abs(p_three.b - al.get(j+1).b);
				System.out.println("three " + p_three.a + " " + p_three.b);

				if(p_three.b!=0) {
					deletes_b += p_three.b;
				}
				ans = Math.max(ans, str.length() - deletes_a - deletes_b);
//				System.out.println(deletes_a + " " + deletes_b);
				deletes_a = temp_a;
				deletes_b = temp_b;
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
//		int tc = sc.nextInt();
		int tc = 1;
		while (tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
}
