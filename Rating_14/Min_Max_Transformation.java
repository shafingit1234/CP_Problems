package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Min_Max_Transformation {
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
	public static long bsearch_min(int start, int end, int val_idx, long[] b, long[] a) {
		long ans = b[val_idx] - a[val_idx];
		while(start <= end) {
			int mid = end + (start - end)/2;
			long diff = b[mid] - a[val_idx];
			if(diff < 0) {
				end = mid-1;
			}
			else if(diff >= 0 && valid(mid,a,b,val_idx)) {
				ans = diff;
				end = mid-1;
			}
			else{
				start = mid+1;
			}
		}
		return ans;
	}
	public static boolean valid_two(int mid_idx, long[] a, long[] b, int val_idx) {
		int s_idx = (val_idx == 0) ? -1 : 0;
		int s_idx_two = (val_idx+1 == a.length ? -1 : val_idx+1);
		for(int i=0 ; i<b.length ; i++) {
			if(i == mid_idx) {
				continue;
			}
			boolean sp1 = true;
			boolean sp2 = true;
			if(s_idx == -1) {
				sp1 = true;
			}
			else {
				if(b[i] - a[s_idx] < 0) {
					sp1 = false;
				}
			}
			if(s_idx_two != -1) {
				if(b[i] - a[s_idx_two] < 0) {
					sp2 = false;
				}
			}
			if(!(sp1 || sp2)) {
				return false;
			}
		}
		return true;
	}
	public static boolean valid(int mid_idx, long[] a, long []b, int val_idx) {
		int s_idx = a.length-1;
		if(s_idx == val_idx) {
			s_idx--;
		}
		for(int i = 0 ; i<b.length ; i++) {
			if(i!=mid_idx) {
				if(b[i] - a[s_idx] >= 0) {
					return true;
				}
			}
		}
		return false;
	}
	public static long bsearch_max(int start, int end, int val_idx, long[] b , long [] a) {
		long ans = b[val_idx] - a[val_idx];
		
		while(start <= end) {
			int mid = end + (start - end)/2;
			long diff = b[mid] - a[val_idx];
			if(diff < 0) {
				end = mid-1;
			}
			else if(diff >= 0 && valid_two(mid,a,b,val_idx)) {
				ans = diff;
				start = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		return ans;
	}
	public static int bsearch1(long[] b, int st, int end, long val)
    {
        int l=st, r=end;
        while(l<=r)
        {
            int mid = (l+r)/2;
 
            if(b[mid]>=val)
            {
                if(mid == 0 || b[mid-1]<val)
                {
                    return mid;
                }
                else
                {
                    r=mid-1;
                }
            }
            else
            {
                l=mid+1;
            }
        }
        return -1;
    }
	public static void findAnswer() {
		int n = sc.nextInt();
		long a[] = new long[n];
		long b[] = new long[n];
		
		for(int i=0 ; i<n ; i++) {
			a[i] = sc.nextLong();
		}
		for(int i=0 ; i<n ; i++) {
			b[i] = sc.nextLong(); 
		}
		
		long dmin[] = new long[n];
		long dmax[] =new long[n];
		int start = 0;
		int end = n-1;
		for(int i=n-1; i>=0 ; i--) {
			int idx = bsearch1(b , start, end , a[i]);
//			dmax[i] = bsearch_max(0 , n-1, i, b,a);
//			dmax[i] = a[n-1] - b[i];
			dmin[i] = b[idx] - a[i];
			dmax[i] = b[end] - a[i];
			if(idx == i) {
				end = i-1;
			}
		}
		for(long i : dmin) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(long i : dmax) {
			System.out.print(i + " ");
		}
		System.out.println();
		return ;
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
