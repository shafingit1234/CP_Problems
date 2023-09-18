package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Wonderful_coloring_2 {
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
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();		
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
			if(hm.containsKey(arr[i]) == false) {
				hm.put(arr[i] , new ArrayList<Integer>());
			}
			hm.get(arr[i]).add(i);
		}
		ArrayList<Integer> al = new ArrayList<>();
		int[] ans = new int[n];
		for(int key : hm.keySet()) {
			ArrayList<Integer> l = hm.get(key);
			if(l.size() >= k) {
				for(int i=0 ; i<k ; i++) {
					ans[l.get(i)] = (i+1);
				}
			}
			else {
				for(int i : l) {
					al.add(i);
				}
			}
		}
		int a = al.size()/k;
		int color = 1;
		for(int i : al) {
			if(a > 0) {
				ans[i] = color++;
				if(color == k+1) {
					a--;
					color = 1;
				}

			}
		}
		
		for(int i = 0 ; i<n ; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		return ;
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
	public static final Random random = new Random();
    public static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
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
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
