package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Little_Girl_and_Maximum_Sum {
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
		int a;
		int b;
		pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	public static class customSort implements Comparator<pair>{
		public int compare(pair p, pair q) {
			if(p.a > q.a) {
				return -1;
			}
			return 1;
		}
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int q = sc.nextInt();
		int arr[] = new int[n];
		int diff[] = new int[n+2];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
//		pair p[] = new pair[q];
//		int k = 0;
		while(q > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			diff[a]++;
			diff[b+1]--;
			q--;
//			p[k++] = new pair(a, b);
		}
		int prefix[] = new int[n+2];
		PriorityQueue<pair> pq = new PriorityQueue<>(new customSort());
		for(int i=1 ; i<diff.length ; i++) {
			prefix[i] = prefix[i-1] + diff[i];
//			System.out.println(prefix[i] + " " + i);
			if(prefix[i] == 0) {
				continue;
			}
			pq.add(new pair(prefix[i] , i));
		}
		Arrays.sort(arr);
		Arrays.sort(prefix);
		long sum = 0;
		for(int i=arr.length-1 ; i>=0 ;i--) {
			if(pq.isEmpty() == true) {
				break;
			}
			sum += ((long)arr[i] * (long)pq.poll().a);
//			sum += arr[i] * prefix[i+1];
//			System.out.println(prefix[i+1]);
//			System.out.println(pq.poll().a);
		}
		System.out.println(sum);
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
