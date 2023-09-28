package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Zero_One_Hard_Version {
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
	public static long recurse(ArrayList<Integer> diff, int idx, long x, long y) {
		if(idx == diff.size()-2){
			if(diff.get(idx) + 1== diff.get(idx+1)) {
				return x;
			}
			return y;
		}
		long sum = Long.MAX_VALUE;
		for(int i = 1 ; i<diff.size()-1 ; i++) {
			int temp_1 = diff.get(0);
			int temp_2 = diff.get(i);
			diff.remove(0);
			diff.remove(i);
			if(temp_1 + 1 == temp_2) {
				sum = Math.min(sum, x + recurse(diff, idx, x, y));
			}
			else {
				sum = Math.min(sum,  y + recurse(diff, idx, x, y));
			}
			diff.add(0 , temp_1);
			diff.add(i, temp_2);
		}
		return sum;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		long x = sc.nextLong();
		long y = sc.nextLong();
		String a = sc.next();
		String b = sc.next();
		ArrayList<Integer> ls =new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			if(a.charAt(i) != b.charAt(i)) {
				ls.add(i);
			}
		}
		if(x >= y) {
			if(ls.size()%2 != 0) {
				System.out.println(-1);
				return ;
			}
			long ans = -1;
			if(ls.size() == 2 && ls.get(0) + 1 == ls.get(1)) {
				if(n == 2) {
					ans = x;
				}
				else {
					ans = Math.min(x,  2*y);
				}
			}
			else {
				ans = (1L*y*ls.size()/2);
			}
			System.out.println(ans);
			return ;
		}
		if(ls.size()%2 != 0) {
			System.out.println(-1);
			return ;
		}
		System.out.println(recurse(ls, 0,x,y));
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
