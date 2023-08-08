package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Ira_and_Flamenco {
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
		int m = sc.nextInt();
		long[] a = new long[n];
		HashMap<Long, Long> hm = new HashMap<>();
		for(int i = 0 ; i<n ; i++) {
			a[i] = sc.nextLong();
			hm.put(a[i] , hm.getOrDefault(a[i], (long) 0) + 1);
		}
//		System.out.println(hm.size());
		int n1 = hm.size();
//		System.out.println(n1);
		long arr[][] = new long[hm.size()][2];
		int i = 0;
		for(Map.Entry<Long, Long> e : hm.entrySet()) {
			arr[i][0] = e.getKey();
			arr[i++][1] = e.getValue();
		}
		//sort the array on the basis of the key.
		Arrays.sort(arr, new Comparator<long[]>(){
			public int compare(long[] o1, long [] o2) {
				return (int)(o1[0] - o2[0]);
			}
		});
		//create a prefix array storing the mulitiplication of frequencies of the elements in the array.
		long[] prefix = new long[hm.size()+1];
		Arrays.fill(prefix, 1l);
		for(int j = 1 ; j<=arr.length; j++) {
			prefix[j] = (prefix[j-1]*arr[j-1][1])%mod;
		}
		
		
		hm.clear();
		HashSet<Long> hs =new HashSet<Long>();
		int start = 0;
		int end= 0;
		long ans = 0;
//		while(end <= n1) {
////			System.out.println(end + " " + start);
//			if(hs.size() == m) {
//				//remove
//				long mult = (prefix[end]/prefix[start]);
//				ans = (ans + mult)%mod;
//				hs.remove(arr[start][0]);
//				start++;
//				if(end < start) {
//					end = start;
//				}
//				continue;
//			}
//			if(end >= n1 || start >= n1) {
//				break;
//			}
//			if(hs.size() < m && Math.abs(arr[start][0] - arr[end][0]) < m) {
//				hs.add(arr[end][0]);
//			}
//			else if(hs.size() < m && Math.abs(arr[start][0] - arr[end][0]) >= m) {
//				hs.remove(arr[start][0]);
//				start++;
//				if(end < start) {
//					end = start;
//				}
//				continue;
//			}
//			end++;
//		}
		for(int k = 0 ; k<n1 ; k++) {
			if(k + m -1 >= n1) {
				break;
			}
			if(arr[k+m-1][0] - arr[k][0] == m-1) {
				ans = (ans + (prefix[k + m])*modInverse(prefix[k], mod)%mod)%mod;
			}
		}
		System.out.println(ans);
	}
	static long modInverse(long A, long M)
    {
        long m0 = M;
        long y = 0, x = 1;
 
        if (M == 1l)
            return 0;
 
        while (A > 1) {
            // q is quotient
            long q = A / M;
 
            long t = M;
 
            // m is remainder now, process
            // same as Euclid's algo
            M = A % M;
            A = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x;
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
