package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Movie_Critics {
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
		int [] arr = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		//remove consecutive duplicates.
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0 ; i<arr.length ;i++) {
			al.add(arr[i]);
			int j = i+1;
			while(j < arr.length && arr[j] == al.get(al.size()-1)) {
				j++;
			}
			if(j == arr.length) {
				break;
			}
			i = j-1;
		}
		int[] rate_of_improvement = new int[k+1];
//		System.out.print(al.get(0) + " ");
		for(int i=1 ; i<al.size()-1 ; i++) {
//			System.out.print(al.get(i) + " ");
			if(al.get(i-1) == al.get(i+1)) {
				rate_of_improvement[al.get(i)] += 2;
			}
			else {
				rate_of_improvement[al.get(i)]+=1;
			}
		}
//		System.out.println(al.get(al.size()-1) + " ");
		rate_of_improvement[al.get(0)]++;
		rate_of_improvement[al.get(al.size()-1)]++;
		//find the max
		int mx = Integer.MIN_VALUE;
		
		int ans = -1;
		for(int i = 0 ; i<rate_of_improvement.length ; i++) {
			if(rate_of_improvement[i] > mx) {
				mx = rate_of_improvement[i];
				ans = i;
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
