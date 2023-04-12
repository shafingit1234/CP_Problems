package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Playing_In_A_Casino {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		int n = sc.nextInt();
		int m =sc.nextInt();
		ArrayList<ArrayList<Long>> al = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			al.add(new ArrayList<Long>());
			for(int j=0 ; j<m ; j++) {
//				al.add();
				al.get(i).add(sc.nextLong());
			}
		}
		ArrayList<Long> temp = new ArrayList<Long>();
		long ans = 0;
		for(int i =0 ; i<m ; i++) {
			temp.clear();
			for(int j=0 ; j<n ; j++) {
				temp.add(al.get(j).get(i));
			}
			Collections.sort(temp);
//			for(int j : temp) {
//				System.out.print(j + " ");
//			}
//			System.out.println();
			long res = 0;
			int ele = temp.size()-1;
			for(int j=ele ; j>=1 ; j--) {
				res += (temp.get(j) - temp.get(ele - j))*j;
			}
//			int temp_ele = ele;
//			for(int j=0 ; j<ele ;j++) {
//				res -= temp.get(j)*temp_ele;
//				temp_ele--;
//			}
			ans += res;
		}
		System.out.println(ans);
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
