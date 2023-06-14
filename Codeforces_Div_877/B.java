package Codeforces_Div_877;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class B {
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
		int arr[] = new int[n];
		int first_idx = 0;
		int second_idx = 0;
		int mx_idx = 0;
		int mx = Integer.MIN_VALUE;
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
			if(mx < arr[i]) {
				mx = arr[i];
				mx_idx = i;
			}
			if(arr[i] == 1) {
				first_idx = i;
			}
			if(arr[i] == 2) {
				second_idx = i;
			}
		}
		boolean check = false;
		int a = Math.max(first_idx, second_idx);
		int b = Math.min(first_idx, second_idx);
		for(int start =b ; start <= a; start++) {
			if(arr[start] == mx) {
				check = true;
//				return ;
				break;
			}
		}
		//1 5 2 3 4
		if(check) {
			System.out.println(1 + " " + 1);
			return ;
		}
		int diff = Math.abs(first_idx - second_idx);
		first_idx++;
		second_idx++;
		mx_idx++;
		if(diff == 1) {
			
			if(first_idx < second_idx) {
				if(mx_idx < first_idx) {
					a = 1;
					b = first_idx;
				}
				else if(mx_idx > second_idx) {
					a = second_idx;
					b = arr.length;
				}
			}
			else {
				if(first_idx < mx_idx) {
					a= first_idx;
					b = arr.length;
				}
				else if(mx_idx < second_idx){
					a= 1;
					b = second_idx;
				}
			}
			System.out.println(a + " " + b);
		}
		else {
			if(first_idx < second_idx) {
				a = first_idx + 1;
				b = mx_idx;
			}
			else {
				a = second_idx + 1;
				b = mx_idx;
			}
			System.out.println(a + " " + b);
		}
		return;
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
