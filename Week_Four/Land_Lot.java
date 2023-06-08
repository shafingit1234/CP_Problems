package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Land_Lot {
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
		int m = sc.nextInt();
		int grid[][] = new int[n][m];
		int prefix[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int a = sc.nextInt();
		int b = sc.nextInt();
		prefix[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			prefix[0][i] = prefix[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < n; i++) {
			prefix[i][0] = prefix[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + grid[i][j];
			}
		}
//		for(int i=0 ; i<n ; i++) {
//			for(int j=0 ; j<m ; j++) {
//				System.out.print(prefix[i][j] + " ");
//			}
//			System.out.println();
//		}
		int temp_a = a - 1;
		int temp_b = b - 1;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int augend = 0;
				int addend = 0;
				int minuend = 0;
				if (i - 1 >= 0 && j - 1 >= 0) {
					minuend = prefix[i - 1][j - 1];
				}
				int temp_x = temp_a + i;
				int temp_y = temp_b + j;
				if(temp_x >= n || temp_y >= m) {
					break;
				}
				if (i - 1 >= 0 && temp_y >= 0) {
					addend = prefix[i - 1][temp_y];
				}
				if (j - 1 >= 0 && temp_x >= 0) {
					augend = prefix[temp_x][j - 1];
				}
				int sum = augend + addend - minuend;
				int diff = prefix[temp_x][temp_y] - sum;
				ans = Math.min(ans, diff);
			}
		}
		int temp = temp_a;
		temp_a = temp_b;
		temp_b = temp;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int temp_x = temp_a + j;
				int temp_y = temp_b + i;
				if(temp_x >= n || temp_y >= m) {
					break;
				}
				int augend = 0;
				int addend = 0;
				int minuend = 0;
				if (i - 1 >= 0 && j - 1 >= 0) {
					minuend = prefix[j - 1][i - 1];
				}
				if (j - 1 >= 0 && temp_y  >= 0) {
					addend = prefix[j - 1][temp_y ];
				}
				if (i - 1 >= 0 && temp_x >= 0) {
					augend = prefix[temp_x ][i - 1];
				}
				
				int sum = augend + addend - minuend;
				int diff = prefix[temp_x][temp_y] - sum;
				ans = Math.min(ans, diff);
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
			findAnswer();
		}
	}
}
