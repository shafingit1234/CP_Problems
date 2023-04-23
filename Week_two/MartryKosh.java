package Week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class MartryKosh {
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
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		Integer arr[]  = new Integer[n];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i =0 ; i<n ; i++) {
			if(hm.containsKey(arr[i]-1) == true && hm.get(arr[i]-1) > 0) {
				hm.put(arr[i]-1 , hm.get(arr[i]-1) - 1);
			}
			hm.put(arr[i] , hm.getOrDefault(arr[i], 0) + 1);
		}
		long ans = 0;
		for(Integer i : hm.values()) {
			ans += i;
		}
		System.out.println(ans);
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		long arr[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		ruffleSort(arr);
		HashMap<Long, ArrayList<Integer>> hm = new HashMap<Long, ArrayList<Integer>>();
		for(int i = 0 ; i<n ; i++) {
			if(hm.containsKey(arr[i]) == false) {
				hm.put(arr[i] , new ArrayList<Integer>());
			}
			hm.get(arr[i]).add(i);
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		long ans = 0;
		for(int i=0 ; i<n ; i++) {
			if(hs.size()==n) {
				break;
			}
			if(hs.contains(i) == true) {
				continue;
			}
			hs.add(i);
			long p=1;
			while(true) {
				if(hm.containsKey(arr[i] + p) == false) {
					break;
				}
				else {
					if(hm.get(arr[i] + p).size() == 0) {
						break;
					}
				}
				int idx = hm.get(arr[i] + p).get(0);
				hs.add(idx);
				hm.get(arr[i] + p).remove(0);
				p++;
			}
			ans++;
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
    public static void ruffleSort(long[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            long temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
	public static void main(String[] args) {
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
}
