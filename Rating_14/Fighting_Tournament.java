package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Fighting_Tournament {
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
		int q = sc.nextInt();
		Deque<Integer> deque
        = new LinkedList<Integer>();
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++) {
//			strength[i] = sc.nextInt();
			deque.addLast(sc.nextInt());
			arr[i] = deque.peekLast();
//			System.out.println(arr[i]);
		}
		
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		int round = 1;
		//below will take O(n) time
		while(deque.peekFirst() != n) {
			int one = deque.pollFirst();
			int two = deque.pollFirst();
//			System.out.println(one + " " + two);
			if(one > two) {
				if(hm.containsKey(one) == false) {
					hm.put(one,  new ArrayList<Integer>());
				}
				hm.get(one).add(round);
				deque.offerLast(two);
				deque.offerFirst(one);
			}
			else {
				if(hm.containsKey(two) == false) {
					hm.put(two, new ArrayList<Integer>());
				}
				hm.get(two).add(round);
				deque.offerLast(one);
				deque.offerFirst(two);
			}
			round++;
		}
		//
		while(q-- > 0) {
			int i = sc.nextInt();
			int k = sc.nextInt();
			
			if(hm.containsKey(arr[i-1]) == false) {
				if(arr[i-1] == n) {
					System.out.println(k);
					continue;
				}
				System.out.println(0);
				continue;
			}
			ArrayList<Integer> al = hm.get(arr[i-1]);
//			int count = 0;
			int mx_round = -1;
			//binary search
			int count = bsearch(al, k);
			if(arr[i-1] == n) {
				if(k > al.get(al.size()-1)) {
					count += k - al.get(al.size()-1);
				}
			}
//			for(int j : al) {
//				if(j <= k) {
//					count++;
//				}
//				mx_round = Math.max(mx_round, j);
//			}
//			if(mx_round < k && arr[i-1] == n) {
//				count += k - mx_round;
//			}
			
			System.out.println(count);
		}
	}
	public static int bsearch(ArrayList<Integer> al, int k) {
		int start = 0;
		int end = al.size()-1;
		int ans = -1;
		while(start <= end) {
			int mid = end + (start - end)/2;
			if(al.get(mid) > k) {
				end = mid-1;
			}
			else {
				ans = mid;
				start = mid+1;
			}
		}
		return ans+1;
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
