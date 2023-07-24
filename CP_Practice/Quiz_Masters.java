package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;


public class Quiz_Masters {
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
		int[] arr= new int[n];
		HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
		int freq[]= new int[m+1];
		for(int i=0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
			if(hm.containsKey(arr[i]) == true) {
				continue;
			}
			hm.put(arr[i] , new HashSet<Integer>());
			for (int j=1; j<=Math.sqrt(arr[i]); j++)
	        {
	            if (arr[i]%j==0)
	            {
	                if (arr[i]/j == j) {
	                	hm.get(arr[i]).add(j);
	                }
	       
	                else {
	                	hm.get(arr[i]).add(j);
	                	hm.get(arr[i]).add(arr[i]/j);
	                }
	            }
	        }
		}
		
//		Arrays.sort(arr);
		ruffleSort(arr);
		int count = m;
		int ans = Integer.MAX_VALUE;
		HashSet<Integer> hs= new HashSet<Integer>();
//		HashSet<Integer> rem = new HashSet<Integer>();
		int start = 0;
		int end = 0;
		while(end <= n) {
			if(hs.size() == m) {
				if(start >= n) {
					break;
				}
				
//				System.out.println(arr[end-1] + " "  + arr[start]);
				ans = Math.min(ans, (arr[end-1] - arr[start]));
				//remove the frequency of factors of arr[start]
				for(int ele : hm.get(arr[start])) {
					if(ele <= m) {
//						continue;
						if(freq[ele] != 0)
							freq[ele]--;
						if(freq[ele] == 0) {
							if(hs.contains(ele) == true) {
								hs.remove(ele);
							}
						}
					}
				}
				start++;
				continue;
			}	
			if(end >= n) {
				break;
			}
			HashSet<Integer> factors = hm.get(arr[end]);
			
			for(int ele : factors) {
				if(ele <= m) {
					freq[ele]++;
					hs.add(ele);
				}

			}
			
			end++;
		}
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
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
//		findAnswer();
	}
}
