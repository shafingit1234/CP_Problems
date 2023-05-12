package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Feed_With_Candy {
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
		int mass;
		int height;
		boolean visited;

		pair(int mass, int height) {
			this.mass = mass;
			this.height = height;
			this.visited = false;
		}
	}

	public static class customSort implements Comparator<pair> {

		@Override
		public int compare(pair o1, pair o2) {
			// TODO Auto-generated method stub
//			return 0;
			if (o2.mass > o1.mass) {
				return 1;
			} else if (o2.mass < o1.mass) {
				return -1;
			}
			return 0;
		}

	}

	public static void findAnswer() {
		int sweets = sc.nextInt();
		long x = sc.nextInt();
		// candy type,height, mass
		ArrayList<pair> m_0 = new ArrayList<pair>();
		ArrayList<pair> m_1 = new ArrayList<pair>();
		for (int i = 0; i < sweets; i++) {
			int turn = sc.nextInt();
			int height = sc.nextInt();
			int mass = sc.nextInt();
			if (turn == 0) {
				m_0.add(new pair(mass, height));
			} else {
				m_1.add(new pair(mass, height));
			}
		}
//		Collections.sort(m_0, new customSort());
//		Collections.sort(m_1, new customSort());
		// fix the turn
//		int chck = -1;
//		while(i < m_0.size()) {
//			if(m_0.get(i).height <= x){
//				chck = i;
//				break;
//			}
//			i++;
//		}
//		while(j < m_1.size() && chck != -1) {
//			if(m_1.get(j).height <= x && m_1.get(j).mass < m_0.get(chck).mass) {
//				turn = 1;
//				break;
//			}
//			else if(m_1.get(j).height <= x && m_1.get(j).mass == m_0.get(chck).mass) {
//				if(m_1.get(j).height <= m_0.get(chck).height) {
//					turn =1;
//					break;
//				}
//			}
//			j++;
//		}
		int sp1 = findAnswer(m_0, m_1, 0, x, sweets);
		int sp2 = findAnswer(m_0, m_1, 1, x, sweets);
		System.out.println(Math.max(sp1, sp2));
	}

	public static int findAnswer(ArrayList<pair> m_0, ArrayList<pair> m_1, int turn, long x, int sweets) {
		int ans = -1;
		for (int i = 0; i < sweets; i++) {
			if (turn == 0) {
				int j = 0;
				int mass = Integer.MAX_VALUE;
				int id = -1;
				for (j = 0; j < m_0.size(); j++) {
					if (m_0.get(j).height <= x && m_0.get(j).visited == false) {
						if (mass > m_0.get(j).mass) {
							id = j;
							mass = m_0.get(j).mass;
						}
					}
				}
				if (id == -1) {
					ans = i;
					break;
				} else {
					turn = 1;
					x += m_0.get(id).mass;
					m_0.get(id).visited = true;
				}

			} else {
				int mass = Integer.MAX_VALUE;
				int id = -1;
				int j = 0;
				for (j = 0; j < m_1.size(); j++) {
					if (m_1.get(j).height <= x && m_1.get(j).visited == false) {
						if (mass > m_1.get(j).mass) {
							id = j;
							mass = m_1.get(j).mass;
						}
					}

				}
				if (id == -1) {
					ans = i;
					break;
				} else {
					turn = 0;
					x += m_1.get(id).mass;
					m_1.get(id).visited = true;
				}

			}
		}
		if (ans == -1) {
			ans = sweets;
		}
		return ans;
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
