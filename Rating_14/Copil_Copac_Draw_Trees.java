package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Copil_Copac_Draw_Trees {
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
		int ele;
		int idx;
		pair(int ele, int idx){
			this.ele = ele;
			this.idx= idx;
		}
	}
	public static Queue<Integer> q;
	public static void findAnswer() {
		int n = sc.nextInt();
		q = new LinkedList<>();
		HashMap<Integer, ArrayList<pair>> hm = new HashMap<>();
		for(int i = 0 ; i<n-1 ; i++) {
			int v = sc.nextInt();
			int u = sc.nextInt();
			
			if(hm.containsKey(v) == false) {
				hm.put(v, new ArrayList<pair>());
			}
			if(hm.containsKey(u) == false) {
				hm.put(u, new ArrayList<pair>());
			}
			hm.get(v).add(new pair(u , i));
			hm.get(u).add(new pair(v, i));
			
		}
//		for(int val : hm.keySet()) {
//			for(pair p : hm.get(val)) {
//				System.out.println(val + " " + p.ele);
//			}
//		}
		HashSet<Integer> hs = new HashSet<>();
		
		q.add(1);
		hs.add(1);
		int count = 0;
		while(q.isEmpty() == false && hs.size() != n) {
			int sze = q.size();
			boolean sp1 = false;
			boolean sp2 = false;
			boolean flag = false;
			while(sze > 0) {
					sze--;
					int v = q.poll();
//					System.out.println(v + " " + count);
					if(hm.containsKey(v) == false) continue;
					for(pair p : hm.get(v)) {
						int u = p.ele;
						int idx = p.idx;
						if(hs.contains(v) && hs.contains(u)) continue;
						if(hs.contains(v) == true) {
							flag = true;
							q.add(u);
							hs.add(u);
							if(hs.size() == n) {
//								System.out.println("hi");
								sp1 = true;
								break;
							}
							dfs(u, idx, hm, hs, n);
							if(hs.size() == n) {
//								System.out.println("hi");
								sp2 = true;
								break;
							}
						}
					}		
			}
//			hs.add(vertex);
//			for(int val : hs) {
//				System.out.print(val + " " + count + " ");
//			}
//			System.out.println();
			
			if(flag) count++;
		}
		System.out.println(count);
		q.clear();
	}
	public static void dfs(int ele, int idx, HashMap<Integer, ArrayList<pair>> hm, HashSet<Integer> hs, int n) {
		if(hm.containsKey(ele) == false) {
			return ;
		}
		if(hs.size() == n) return ;
//		System.out.println(ele + " " + idx);
		for(pair p : hm.get(ele)) {
			int u = p.ele;
			int u_idx = p.idx;
			if(u_idx > idx) {
				hs.add(u);
				q.add(u);
				if(hs.size() == n) return;
				dfs(u , u_idx, hm, hs, n);
			}
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
