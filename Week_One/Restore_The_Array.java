package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Restore_The_Array {
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
		long arr[] = new long[n-1];
		for(int i=0; i<n-1 ; i++) {
			arr[i] = sc.nextLong();	
		}
		ArrayList<Long> al = new ArrayList<>();
		al.add(arr[0]);
		for(int i=0 ; i<arr.length-1 ; i++) {
			long diff = Math.min(arr[i],arr[i+1]);
			al.add(diff);
		}
//		al.add(Math.max(, b))
		long diff = al.get(al.size()-1);
		long diff_two = arr[arr.length-1];
		al.add(Math.max(diff, diff_two));
		for(long l : al) {
			System.out.print(l + " ");
		}
		System.out.println();
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
