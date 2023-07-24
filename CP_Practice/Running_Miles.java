package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Running_Miles {
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
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int l[]=new int[n];
        int r[]=new int[n];
        for(int i=0;i<n;i++){
            l[i]=arr[i]+i;
        }
        for(int i=0;i<n;i++){
            r[i]=arr[i]-i;
        }

        int ans=0;
        int maxl[]=new int[n];
        int maxr[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                maxl[i]=l[i];
            }
            else{
                maxl[i]=Math.max(l[i],maxl[i-1]);
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(i==n-1){
                maxr[i]=r[i];
            }
            else{
                maxr[i]=Math.max(r[i],maxr[i+1]);
            }
        }
        for(int i=1;i<n-1;i++){
            ans=Math.max(ans,arr[i]+maxl[i-1]+maxr[i+1]);
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
