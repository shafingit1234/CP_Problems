package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Boris_and_Hair_Cuts {
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
		int start;
		int end;
		pair(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		HashMap<Integer , Integer> freq = new HashMap<>();
		for(int i = 0 ; i<n ; i++) {
			a[i] = sc.nextInt();		
		}
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		for(int i = 0 ; i<n ; i++) {
			b[i] = sc.nextInt();
//			hm.put(b[i], new ArrayList<Integer>());
		}
		
		int m = sc.nextInt();
		
	//before this construct an array that tells the left maximum value found so far.
		
		int left[]  = new int[n];
		int right[] = new int[n];
		for(int i=0 ; i<m ; i++) {
//			m_arr[i] =sc.nextInt();
			int temp = sc.nextInt();
			//8 
			freq.put(temp , freq.getOrDefault(temp, 0) + 1);
		}
		for(int i=0 ; i<b.length ; i++) {
			if(a[i] < b[i]) {
				System.out.println("NO");
				return ;
			}
			else if(a[i] == b[i]) continue;
			else {
				if(hm.containsKey(b[i]) == false) {
					hm.put(b[i] , new ArrayList<Integer>());
				}
				hm.get(b[i]).add(i);
			}
		}
		findJustGreater(left, right, b);
		
		HashSet<String> res = new HashSet<>();
		for(int i : hm.keySet()) {
			if(hm.get(i).size() == 0) continue;
			if(freq.containsKey(i) == false) {
//				System.out.println(i);
				System.out.println("NO");
				return;
			}
			ArrayList<Integer> al = hm.get(i);
			for(int ele : al) {
				int left_idx = left[ele];
				int right_idx = right[ele];
				res.add(left_idx + " " + right_idx);
			}
//			System.out.println(i + " " + res.size());
			if(res.size() > freq.get(i)) {
				System.out.println("NO");
				return ;
			}
			res.clear();
		}
		System.out.println("YES");
		return ;
	}
	public static void findJustGreater(int[] left,int[] right, int[] b) {
		Stack<Integer> st = new Stack<Integer>();
		for(int i = b.length-1 ; i>=0 ; i--) {
			while(st.size() > 0 && b[st.peek()] < b[i]) {
				left[st.peek()] = i;
				st.pop();
			}
			st.push(i);
		}
		while(st.size() > 0) {
			left[st.peek()] = -1;
			st.pop();
		}
		for(int i = 0 ; i<b.length ; i++) {
			while(st.size() > 0 && b[st.peek()] < b[i]) {
				right[st.peek()] = i;
				st.pop();
			}
			st.push(i);
		}
		while(st.size() > 0) {
			right[st.peek()] = -1;
			st.pop();
		}
		return ;
		
	}
	
	public static void findAnswer() {
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
//		int m = sc.nextInt();
//		int m_arr[] = new int[m];
		HashMap<Integer , Integer> freq = new HashMap<>();
		for(int i = 0 ; i<n ; i++) {
			a[i] = sc.nextInt();		
		}
		HashMap<Integer, ArrayList<pair>> hm = new HashMap<>();
		for(int i = 0 ; i<n ; i++) {
			b[i] = sc.nextInt();
			hm.put(b[i], new ArrayList<pair>());
		}
		int m = sc.nextInt();
		//before this construct an array that tells the left maximum value found so far.
		int left[]  = new int[n];
		for(int i=0 ; i<m ; i++) {
//			m_arr[i] =sc.nextInt();
			int temp = sc.nextInt();
			//8 
			freq.put(temp , freq.getOrDefault(temp, 0) + 1);
		}
//		int prev = b[n-1];
		int start = -1;
		int end = -1;
		for(int i = n-1 ; i>=0 ; i--) {
			if(a[i] < b[i]) {
				System.out.println("NO");
				return ;
			}
			if(a[i] == b[i]) {
				if(start != -1) {
					hm.get(b[i+1]).add(new pair(start, end));
					start = -1;
					end = -1;
				}
				continue;
			}
			else {
				if(start == -1) {
					start = i;
					end = i;
				}
				else {
					if(b[i+1] == b[i]) {
						end = i;
					}
					else {
						//create a new segment, but before that store the previous segment.
						hm.get(b[i+1]).add(new pair(start, end));
						start = i;
						end = i;
					}
				}
			}
		}
		if(start != -1) {
			hm.get(b[0]).add(new pair(start, end));
		}
		left[0] = b[0];
		for(int i=1 ; i<n ; i++) {
			left[i] = Math.max(left[i-1], b[i]);
		}
		 int [] prevG = new int[n];
		 Stack<Integer>st = new Stack<>();
		 for(int i = n-1;i>=0;i--)
		 {
			 while(st.size()>0&&b[st.peek()]<b[i])
			 {
				 prevG[st.peek()] = i;
				 st.pop();
			 }
			 st.push(i);
		 }
//		 for(int i =0; i<n ; i++) {
//			 System.out.println(left[i] + " " + prevG[i]);
//		 }
//		for(int i : hm.keySet()) {
////			System.out.print(i+ " ");
//			for(pair p : hm.get(i)) {
//				System.out.println(i + " " + p.start + " " + p.end);
//			}
//			
//		}
//		System.out.println("---------------------------");
//		for(int i : hm.keySet()) {
//			ArrayList<pair> p = hm.get(i);
//			if(p.size() == 0) {
//				continue;
//			}
//			if(freq.containsKey(i) == false) {
////				System.out.println("hi");
////				System.out.println(i);
//				System.out.println("NO");
//				return;
//			}
//			if(freq.get(i) >= p.size()) {
//				continue;
//			}
//			int res = 0;
//			for(pair item : p) {
//				if(left[item.start] <= i && left[item.end] <= i) {
//					res++;
//				}
//			}
//			int sze = p.size() - res + 1;
////			System.out.println(i + " " + sze + " " + freq.get(i));
//			if(freq.get(i) < sze) {
////				continue;
//				System.out.println("NO");
//				return ;
//			}
//		}
		System.out.println("YES");
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
			findAnswerTwo();
		}
	}
}
