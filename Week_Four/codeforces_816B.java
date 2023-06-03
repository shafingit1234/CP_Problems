package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class codeforces_816B {
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
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		ArrayList<pair> al = new ArrayList<pair>();
		//form a prefix sum array
		int[] prefix = new int[200002];
		for(int i=0 ; i<n ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pair p = new pair(a, b);
			al.add(p);
			prefix[a]++;
			prefix[b+1]--;
		}
		//form another array that will help in telling possible recipies between a certain range.
		int[] tell = new int[200002];
		int count = 0;
		int spots = 0;
		for(int i=0 ; i<prefix.length ; i++) {
			count += prefix[i];
			if(count >= k) {
				spots++;
			}
			tell[i] = spots;
		}
		//answer the queries
//		for(int i=90 ; i<)
		while(q > 0) {
			q--;
			int a = sc.nextInt();
			int b  =sc.nextInt();
			System.out.println(tell[b] - tell[a-1]);
		}
		return ;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		ArrayList<pair> al = new ArrayList<pair>();
		for(int i=0 ; i<n ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			al.add(new pair(a, b));
		}
		while(q > 0) {
			q--;
			//first find maximum number in questions range that satisfy at least k recipes, then find the minimum
			int a = sc.nextInt();
			int b = sc.nextInt();
			int start = a;
			int end = b;
//			int count =0;
			int ans = 0;
			while(start <= end) {
				int count = 0;
				int mid = start + (end-start)/2;
				System.out.println(mid + "hi");
				for(int i = 0 ; i<n ; i++) {
					pair p = al.get(i);
					if(mid >= p.a && p.b >= mid) {
						count++;
						if(count >= k) {
							break;
						}
					}
					
				}
				if(count >= k) {
					ans = mid;
					start = mid+1;
//					System.out.println(start + "hi2");
				}
				else {
					end = mid-1;
				}
			}
//			System.out.println(ans);
			int mxValidNumber = ans;
			start = a;
			end = b;
			ans = 0;
			//now go for minimum number
			while(start <= end) {
				int count = 0;
				int mid = start + (end -start)/2;
				System.out.println(mid+"bye");
				for(int i=0 ; i<n ; i++) {
					pair p = al.get(i);
					if(mid >= p.a && p.b >= mid) {
						count++;
					}
					if(count >= k) {
						break;
					}
				}
				if(count >= k) {
					ans= mid;
					end = mid - 1;
				}
				else {
					
					start = mid+1;
				}
			}
			int mnValidNumber = ans;
//			System.out.println(ans);
			System.out.println("----");
			System.out.println(mxValidNumber - mnValidNumber);
		}
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
//			findAnswer();
			findAnswerTwo();
		}
	}
}
