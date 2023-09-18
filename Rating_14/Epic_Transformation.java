package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Epic_Transformation {
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
		long element;
		int size;
		pair(long element, int size){
			this.size = size;
			this.element = element;
		}
	}
	public static class customSort implements Comparator<pair>{
		public int compare(pair p1, pair p2) {
			if(p1.size > p2.size) {
				return -1;
			}
			return 1;
		}
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		HashMap<Long, ArrayList<Integer>> hm = new HashMap<>();
		for(int i=0 ; i<n ; i++) {
			long temp = sc.nextLong();
//			arr[i] = temp;
			if(hm.containsKey(temp) == false) {
//				store.add(temp);
				hm.put(temp, new ArrayList<Integer>());
			}
			hm.get(temp).add(i);
		}
//		sort on the basis of size of arraylist
		PriorityQueue<pair> pq = new PriorityQueue(new customSort());
		for(long k : hm.keySet()) {
			int size = hm.get(k).size();
			pair p1 = new pair(k , size);
			pq.add(p1);
		}
//		printPq(pq);
		while(pq.size() >= 2) {
			pair p_1 = pq.poll();
			pair p_2 = pq.poll();
			p_1.size--;
			p_2.size--;
			if(p_1.size != 0) {
				pq.add(p_1);
			}
			if(p_2.size != 0) {
				pq.add(p_2);
			}
		}
		int ans = 0;
		while(pq.isEmpty() == false) {
			ans += pq.poll().size;
		}
		System.out.println(ans);
	}
	public static void printPq(PriorityQueue<pair> pq) {
		Iterator<pair> value = pq.iterator();
		while(value.hasNext()) {
//			System.out.println(value.next().element);
			pair p = value.next();
			System.out.println(p.element + " " + p.size);
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
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
