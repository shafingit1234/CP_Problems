package Week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Search_In_Parallel {
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
	public static class pair implements Comparable<pair>{
		long ele;
		int idx;
		pair(long ele, int idx){
			this.ele = ele;
			this.idx = idx;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
//			return 0;
			if(this.ele > o.ele) {
				return -1;
			}
			else if(this.ele == o.ele) {
				return Integer.compare(this.idx,o.idx);
			}
			return 1;
		}
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		ArrayList<Integer> robot_one = new ArrayList<Integer>();
		ArrayList<Integer> robot_two = new ArrayList<Integer>();
		long arr[] = new long[n];
		ArrayList<pair> temp = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
			temp.add(new pair(arr[i], i));
		}
//		Arrays.sort(arr ,);
		Collections.sort(temp);
		
		int curr_time = 0;
		int i_one = 1;
		int i_two = 1;
		while(curr_time < n) {
			if(i_one*s1  > i_two*s2) {
				robot_two.add(temp.get(curr_time).idx + 1);
				i_two++;
			}
			else {
				robot_one.add(temp.get(curr_time).idx + 1);
				i_one++;
			}
			curr_time++;
		}
//		find what is needed.
		/*
		 * 7 3 1
8 6 4 4 4 1 7
		 * 
		 * */
		System.out.print(robot_one.size() + " ");
		for(int idx : robot_one) {
			System.out.print(idx + " ");
		}
		System.out.println();
		System.out.print(robot_two.size() + " ");
		for(int idx : robot_two) {
			System.out.print(idx + " ");
		}
		System.out.println();
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
	public static void main(String[] args) {
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
