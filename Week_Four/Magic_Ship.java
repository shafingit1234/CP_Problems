package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Magic_Ship {
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
		long x_1 = sc.nextLong();
		long x_2 = sc.nextLong();
		long finalx_1 = sc.nextLong();
		long finalx_2 = sc.nextLong();
		int n = sc.nextInt();
		String str = sc.next();
		char arr[] = str.toCharArray();
		long changeX[] = new long[n+1];
		long changeY[] = new long[n+1];
		for(int i=0 ; i<n ; i++) {
			changeX[i+1] = changeX[i];
			changeY[i+1] = changeY[i];
			if(arr[i] == 'U') {
				changeY[i+1]++;
			}
			else if(arr[i] == 'D') {
				changeY[i+1]--;
			}
			else if(arr[i] == 'L') {
				changeX[i+1]--;
			}
			else if(arr[i] == 'R') {
				changeX[i+1]++;
			}
		}
		long start = 0;
		long end = (long)1e15;
		long ans = -1;
		while(start <= end) {
			long mid = start + (end - start)/2;
//			System.out.println(start + " " + mid + " " + end);
			long finalX = x_1 + ((mid/n)*changeX[(int) (n)] + changeX[(int) (mid%n)]);
			long finalY = x_2 + ((mid/n)*changeY[(int) (n)] + changeY[(int) (mid%n)]);
			long steps_needed = Math.abs(finalx_1 - finalX) + Math.abs(finalx_2 - finalY);
			if(steps_needed <= mid) {
				ans = mid;
				end = mid-1;
			}
			else {
				start = mid+1;
			}
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
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
