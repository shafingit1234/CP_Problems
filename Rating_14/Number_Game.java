package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Number_Game {
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
	public static boolean remove(ArrayList<Integer> arr, int val) {
		int idx = -1;
		for(int i=arr.size() ; i>=0 ; i--) {
			if(arr.get(i) <= val) {
				idx= i;
			}
			else {
				break;
			}
		}
		if(idx == -1) {
			return false;
		}
		arr.remove(idx);
		return true;
	}
	public static boolean update(ArrayList<Integer> arr, int mid, int stage) {
		if(arr.isEmpty() == true) {
			return false;
		}
		int val = mid - stage;
		int idx = 0;
		for(int i =0  ; i<arr.size() ; i--) {
			if(arr.get(i) <= val) {
				idx = i;
			}
			else {
				break;
			}
		}
		arr.set(idx, arr.get(idx) + (mid - (stage) + 1));
		return true;
		
	}
	public static boolean isValid(int mid, ArrayList<Integer> arr) {
		if(arr.isEmpty() == false) {
			return false;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(arr);
		for(int stage = 1; stage <= mid ; stage++) {
			int val = mid - stage + 1;
			boolean sp = remove(temp, val);
			if(sp == false) {
				return false;
			}
			sp = update(temp, mid ,stage);
			if(sp == false) {
				return true;
			}
		}
		return true;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0 ; i<n ; i++) {
			al.add(sc.nextInt());
		}
		Collections.sort(al);
		int start = 1;
		int end = n;
		int ans = -1;
		while(start <= end) {
			int mid = end + (start - end)/2;
			if(isValid(mid, al)) {
				ans = mid;
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		System.out.println(ans);
	}
	public static boolean isValid(int k , int[] arr) {
		int[] new_arr = Arrays.copyOf(arr, arr.length);
		for(int stage = 1 ; stage <= k  ; stage++) {
			int val = k - stage + 1;
			int mx = -1;
			for(int i = 0 ; i<new_arr.length ; i++) {
				if(new_arr[i] == -1) {
					continue;
				}
				if((mx == -1 || new_arr[mx] < new_arr[i]) && new_arr[i] <= val) {
					mx = i;
				}
			}
			if(mx == -1) return false;
			new_arr[mx] = -1;
			int mn = -1;
			for(int i=0 ; i<new_arr.length ; i++) {
				if (new_arr[i] == -1) continue;
                if (mn == -1 || new_arr[i] < new_arr[mn]) mn = i;
			}
			if(mn >= 0) {
				new_arr[mn] += val;
			}
		}
		return true;
	}
	public static void findAnswerTwo() {
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] =sc.nextInt();
		}
		
		for(int k = n ; k>=0 ; k--) {
			if(isValid(k , arr) == true) {
				System.out.println(k);
				break;
			}
		}
//		System.out.println();
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
