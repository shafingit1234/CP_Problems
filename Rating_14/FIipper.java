package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class FIipper {
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
		int a[] =new int[n];
		for(int i=0 ; i<n ; i++) {
			a[i] = sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		int tar = a[0] == n ? n-1 : n;
		if(n>=2){
			for(int i = 0;i<n;i++){
				if(a[i] == tar){
					for(int j = i;j<n;j++)sb.append(a[j]+" ");
					int l = i-1;
					if(i == n-1 && a[0]>a[l]){
						l = i;
					}else{
						sb.append(a[l]+" ");
						while(l-1>=0 && a[l-1]>a[0]){
							l--;
							sb.append(a[l]+" ");
							
						}
					}

					for(int j =0;j<l;j++)sb.append(a[j]+" ");
					break;
				}
			}
		}
		else sb.append(a[0]);
		sb.append("\n");
		System.out.println(sb.toString());
	}
	public static String reverse(String str) {
		String temp = "";
		for(int i = str.length() - 1 ; i >= 0 ; i--) {
			temp = temp + str.charAt(i);
		}
		return temp;
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
