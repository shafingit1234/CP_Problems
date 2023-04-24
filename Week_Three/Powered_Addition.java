package Week_Three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Powered_Addition {
	public static FastScanner sc = new FastScanner();
	public static long mod = (long)(1e9 + 7);
	public static long computePower(int base, int power) {
//        int base = 2;
//        int power = 3;
        long ans = 1;
        while (power > 0){
            if ((power&1)==1){
               // if == 0 there is no point to calculate ans
                ans = ans * base;
            }
            base = base * base;
            // keep dividing power by 2 using right shift
            power = power >> 1;
        }
//        System.out.println(ans);
        return ans;
    }
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
		long arr[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
		}
		int ans = 0;
		for(int i=1 ; i<n ; i++) {
			if(arr[i-1] > arr[i]) {
//				int temp_idx = i;
//				boolean check = false;
//				for(int j= i + 1; j<n ; j++) {
//					if(arr[j-1] < arr[j]) {
//						continue;
//					}
//					else {
//						check = true;
//						temp_idx = j;
//						break;
//					}
//				}
//				if(check == false) {
//					temp_idx = n;
//				}
				int j = ans+1;
				long diff = arr[i-1] - arr[i];
				for( j = 0; j<=31 ; j++) {
					if(((1<<(j))&(diff))!=0) {
//						ans = j;
						ans = Math.max(ans, j+1);
//						break;
					}
				}
				arr[i] = arr[i-1];
//				arr[temp_idx - 1] += (Math.pow(2,  ans-1));
//				i = temp_idx-1;
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
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
