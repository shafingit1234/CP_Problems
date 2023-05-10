package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Maximum_Median {
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
		long key;
		int idx;
		int lastIdx;
		pair(long key, int idx , int lastIdx){
			this.key = key;
			this.idx = idx;
			this.lastIdx = lastIdx;
		}
//		@Override
//		public int compare(pair o1, pair o2) {
//			// TODO Auto-generated method stub
////			return 0;
////			return 1;
//			if(o1.key > o2.key) {
//				return 1;
//			}
//			return -1;
//		}
		
		
	}
	public static class customSort implements Comparator<pair>{
		public int compare(pair p1, pair p2) {
			return 1;
		}
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		long k = sc.nextLong();
		long arr[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		int start = n/2;
		long temp[] = new long[n - start];
//		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		PriorityQueue<pair> hm = new PriorityQueue<>(new customSort());
		HashSet<Long> hs = new HashSet<Long>();
		for(int i = start ; i<n ; i++) {
			temp[i - start] = arr[i];
			if(i==start) {
				continue;
			}
			else if(hs.contains(arr[i])) {
				pair p_temp = hm.poll();
				p_temp.lastIdx = i;
				hm.offer(p_temp);
				continue;
			}
			hs.add(arr[i]);
//			System.out.println(arr[i]);
			hm.offer(new pair(arr[i] , i , i));
		}
		boolean check = false;
		int cnt = 0;
		while(k > 0 && hm.isEmpty() == false) {
			long strt = 1;
			long end = 10;
			int idx = -1;
			if(temp[0] == hm.peek().key) {
				idx = hm.peek().lastIdx;
				hm.poll();
//				System.out.println(idx);
				if(hm.isEmpty() == false) {
					end = hm.peek().key - temp[0];
				}
				
			}
			else {
				idx= hm.peek().idx - 1;
				end = hm.peek().key - temp[0];
			}
			long ans = -1;
			
			while(strt <= end) {
				cnt++;
				long mid = strt + (end - strt)/2;
//				System.out.println(mid + " " + (idx - start + 1));
				if(mid <= 0) {
					break;
				}
//				System.out.println(mid);
//				System.out.println((idx - start + 1));
				if((idx - start + 1)*mid > k) {
					end = mid-1;
				}
				else {
					ans = mid;
					strt = mid+1;
				}
//				cnt++;
			}
			
			if(ans == -1) {
				check = true;
				break;
			}
			temp[0] += ans;
			k = k - ((idx - start + 1)*ans);
			if(k <= 0) {
				break;
			}
			
		}
		
		
		System.out.println(temp[0]);
		
	}
	public static boolean check(long val, long k, long arr[]) {
		int idx = arr.length/2;
		while(idx < arr.length && arr[idx] < val) {
			if(val - arr[idx] > k) return false;
			k = k - (val-arr[idx]);
			idx++;
		}
		return true;
	}
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		long k = sc.nextLong();
		long arr[] = new long[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		long start = arr[n/2];
		long end = k + (long)1e9;
		while(start <= end) {
			long mid = start + (end - start)/2;
			if(check(mid, k, arr)) {
//				ans = mid
				start = mid+1;
			}
			else {
//				ans = mid;
				end = mid-1;
			}
		}
//		System.out.println(arr[n/2] + end);
		System.out.println(end);
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
