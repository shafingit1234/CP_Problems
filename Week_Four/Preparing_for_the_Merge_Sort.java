package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Preparing_for_the_Merge_Sort {
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
		long temp[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
			temp[i] = arr[i];
		}
		Arrays.sort(temp);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			//find index in sorted array
			int start = 0;
			int end= n-1;
			int mid = -1;
			while(start <= end) {
				mid = start + ( end - start)/2;
				if(temp[mid] == arr[i]) {
					break;
				}
				else if(temp[mid] > arr[i]) {
					end = mid - 1;
				}
				else {
					start = mid+1;
				}
			}
//			System.out.println(arr[i] + " " + temp[mid]);
			start = 0;
			end = res.size()-1;
			int ans = -1;
			while(start <= end) {
				int temp_mid = start + (end - start)/2;
				int sze = res.get(temp_mid).size()-1;
				if(res.get(temp_mid).get(sze) >= mid) {
//					ans = temp_mid;
					start = temp_mid + 1;
				}
				else {
					ans = temp_mid;
					end = temp_mid - 1;
				}
			}
			if(ans == -1) {
				res.add(new ArrayList<Integer>());
				ans = res.size()-1;
			}
//			System.out.println(ans + " " + temp[mid]);
			res.get(ans).add(mid);
		}
		for(ArrayList<Integer> al : res) {
			for(int i : al) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
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
			findAnswer();
		}
	}
}
