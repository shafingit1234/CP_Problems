package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Add_Modulo_10 {
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
		long arr[] = new long[n];
		boolean flag = false;
		boolean all_10s = true;
		boolean factor_of_ten = false;
		boolean all_same = true;
		long temp = -1;
		long mn = Integer.MAX_VALUE;
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
			mn = Math.min(arr[i], mn);
			if(i == 0) {
				temp = arr[i];
			}
			if(temp != arr[i]) {
				all_same = false;
			}
			if(arr[i] == 5) {
				flag = true;
			}
			if(arr[i] != 10) {
				all_10s = false;
			}
			if(arr[i]%10 == 0) {
				factor_of_ten = true;
			}
		}
		if(flag == true) {
			for(int i = 0 ; i<n ; i++) {
				if(arr[i] == 5) continue;
				if(arr[i] != 10) {
					System.out.println("NO");
					return ;
				}
			}
			System.out.println("YES");
			return ;
		}
		if(all_10s == true || all_same == true) {
			System.out.println("YES");
			return ;
		}
		if(factor_of_ten == true) {
			System.out.println("NO");
			return ;
		}
		
		for(int i = 0 ; i<n ; i++) {
			boolean tmp = false;
			if(mn == arr[i]) {
				tmp = true;
			}
			while(arr[i]%10 != 2) {
				arr[i] = arr[i] + arr[i]%10;
			}
			if(tmp == true) {
				mn = arr[i];
			}
		}
		for(int i=0 ; i<n ; i++) {
			if(arr[i] != mn) {
				if(check(mn, arr[i]) == false) {
					System.out.println("NO");
					return ;
				}
			}
		}
		System.out.println("YES");
		return ;
	}
	public static boolean check(long a, long b) {
//		while(a%10 != 2) {
//			a = a + a%10;
//		}
//		while(b%10 != 2) {
//			b = b + b%10;
//		}
		if((b-a)%20 != 0) {
			return false;
		}
		return true;
		
	}
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		long arr[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
		}
		long mn = Integer.MAX_VALUE;
		int count = 0;
		for(int i=0 ; i<n ; i++) {
			while(arr[i]%10 != 2 && arr[i]%10 != 0) {
				arr[i] += (arr[i]%10);
			}
			if(arr[i] == 10) {
				count++;
			}
			mn = Math.min(mn, arr[i]);
		}
		if(count == n) {
			System.out.println("YES");
			return  ;
		}
		for(int i=1 ; i<n ; i++) {
			long a = Math.min(arr[i], arr[i-1]);
			long b = Math.max(arr[i], arr[i-1]);
			if(a%10 == 0 || b%10 == 0) {
				if(a != b) {
					System.out.println("NO");
					return ;
				}
				else continue;
			}
			if((b-a)%20 != 0) {
				System.out.println("NO");
				return ;
			}
		}
		System.out.println("YES");
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
			findAnswerTwo();
		}
	}
}
