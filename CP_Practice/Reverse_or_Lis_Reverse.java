package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Reverse_or_Lis_Reverse {
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
	public static void findAnswerThree() {
		//1 1 2 3 3 
		int n = sc.nextInt();
		int[] arr = new int[n];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0 ;i<n ; i++) {
			int temp = sc.nextInt();
			if(hm.containsKey(temp) == false) {
				hm.put(temp, 1);
			}
			else if(hm.containsKey(temp) == true) {
				hm.put(temp, hm.get(temp) + 1);
			}
		}
		int ans = 0;
		for(int i : hm.values()) {
			ans += Math.min(i, 2);
		}
//		System.out.println(ans);
		System.out.println((ans+1)/2);
		
	}
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		int[] min_arr = new int[n];
		int[] max_arr = new int[n];
		for(int i=0 ; i < n ; i++) {
			min_arr[i] = sc.nextInt();
		}
		Arrays.sort(min_arr);
		int j = 0;
		int start = 0;
		int end = n-1;
		boolean flag = false;
		while(start < end) {
			if(flag == false) {
				max_arr[start] = min_arr[j];
				max_arr[end] = 	min_arr[n-j-1];
				flag = true;
			}
			else {
				max_arr[start] = min_arr[n-j-1];
				max_arr[end] = min_arr[j];
				flag = false;
			}
			
			start++;
			end--;
			j++;
		}
		if(start == end) {
			max_arr[start] = min_arr[j];
		}
		int ans = utilFindAnswer(max_arr);
		System.out.println(ans);
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int[] min_arr = new int[n];
		int[] max_arr = new int[n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq_one = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0 ; i<n ; i++) {
			int temp = sc.nextInt();
//			arr[i] = sc.nextInt();
			pq.add(temp);
			pq_one.add(temp);
			
		}
		int start = 0;
		int end = n-1;
	
		while(start <= end) {
			
			min_arr[start] = pq.poll();
			if(start != end)
				min_arr[end] = pq.poll();
			start++;
			end--;
		}
	
		start = 0;
		end = n-1;
		
		while(start <= end) {
			max_arr[start] = pq_one.poll();
			if(start != end)
				max_arr[end] = pq_one.poll();
			start++;
			end--;
		}
		//find answer in min_arr
		int ans_one = utilFindAnswer(min_arr);
		int ans_two = utilFindAnswer(max_arr);
		ans_one = Math.max(ans_one, ans_two);
		System.out.println(ans_one);
		
	}
	public static int utilFindAnswer(int[] arr) {
		int mxLeft = 1;
		int mxRight= 1;
		for(int i=1 ; i<arr.length ; i++) {
			if(arr[i-1] < arr[i]) {
				mxLeft++;
			}
		}
		for(int j=arr.length-2 ; j >=0 ; j--) {
			if(arr[j] > arr[j+1]) {
				mxRight++;
			}
		}
		return Math.min(mxLeft, mxRight);
		
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
//			findAnswer();
			findAnswerThree();
		}
	}
}
