package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Keshi_Throws_A_Party {
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
	public static class pair{
		int a;
		int b;
		pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	public static boolean isValid(int mid, ArrayList<pair> temp) {
		if(mid == 0) return true;
		int selected= 0 ;
		for(int i=1; i<=temp.size() ; i++) {
			if((selected) <= temp.get(i-1).b && (mid - 1) <= temp.get(i-1).a) {
//				System.out.println(temp.get(i-1).b + " " + temp.get(i-1).a);
//				continue;
				selected++;
				mid--;
			}
			if(mid == 0) {
				return true;
			}
		}
//		System.out.println("hi");
		return false;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		ArrayList<pair> pr = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			pair p = new pair(sc.nextInt()  , sc.nextInt());
			pr.add(p);
		}
		int start = 1;
		int end = n;
//		System.out.println(end);
		int ans = n;
		while(start <= end) {
			int mid = start + (end - start)/2;
//			System.out.println(mid);
			if(isValid(mid, pr) == true) {
				ans = mid;
				start = mid+1;
			}
			else {
				
				
				end = mid-1;
			}
		}
//		System.out.println(end + " " + ans);
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
