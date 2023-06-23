package Rating_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Removing_Graph {
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
	public static int findSizes(boolean[] visited , int start_node) {
		if(visited[start_node] == true) {
			return 0;
		}
		visited[start_node] = true;
		int ans = 1;
		for(int temp : graph.get(start_node)) {
			if(visited[temp] == false) {
				ans += (findSizes(visited, temp));
			}
		}
		return ans;
	}
	public static ArrayList<ArrayList<Integer>> graph ;
	public static void findAnswer() {
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		//create a graph.
		graph = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			a--;
			b--;
			if(graph.size() <= Math.max(a,b)) {
				for(int j=graph.size()-1 ; j<Math.max(a,  b)+1; j++) {
					graph.add(new ArrayList<Integer>());
				}
			}
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
//		int [] cycle = new int[n+1];
		boolean[] visited = new boolean[n];
//		for(int i=0; i<=(n) ; i++) {
////			cycle[i] = 0;
//			if(i < l) {
//				cycle[i] = 0;
//			}
//			else if(i < r+l) {
//				cycle[i] = (int)(i/l);
//			}
//			else if(i >= r+l){
//				cycle[i] = 0;
//			}
//		}
		int res = 0;
		for(int i=0 ; i<visited.length ; i++) {
			if(visited[i] == false) {
				int size = findSizes(visited , i);
//				System.out.println("size "+ size);
				if(size <= (r + l -1)) {
					res ^= (int)(size / l);
				}
			}
		}
		if(res == 0) {
			System.out.println("Bob");
		}
		else {
			System.out.println("Alice");
		}
		// use dfs to find cycles in graph.
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
