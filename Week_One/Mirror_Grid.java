package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Mirror_Grid {
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
		int grid_size = sc.nextInt();
		int grid[][] = new int[grid_size+1][grid_size+1];
		for(int i=1 ; i<=grid_size ; i++) {
			String str = sc.next();
			for(int j = 1 ; j<=grid_size ; j++) {
//				char ch = sc.next().charAt(0);
				grid[i][j] = str.charAt(j-1) - '0';
			}
		}
//		check for cases
		int count = 0;
		int equal = 0;
		for(int i= 1 ; i<=grid_size ; i++) {
			for(int j=1 ; j<=grid_size; j++) {
				int cnt_one = grid[i][j] + grid[j][grid_size-i+1] + grid[grid_size-j+1][i] + grid[grid_size-i+1][grid_size-j+1];
				int cnt_zero = 4 - cnt_one;
				int diff = Math.abs(cnt_one - cnt_zero);
				int add = Math.min(cnt_one, cnt_zero);
				if(diff == 4) {
					continue;
				}
				else if(cnt_one > cnt_zero) {
					count+=add;
					grid[i][j] = 1;
					grid[j][grid_size-i+1] = 1;
					grid[grid_size-j+1][i] = 1;
					grid[grid_size-i+1][grid_size-j+1] = 1;
				}
				else {
					count+=add;
					grid[i][j] = 0;
					grid[j][grid_size-i+1] = 0;
					grid[grid_size-j+1][i] = 0;
					grid[grid_size-i+1][grid_size-j+1] = 0;
				}
			}
		}
		System.out.println(count);
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
