package Codeforces_educational_contest_147;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class B {
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
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		int [] arr_one = new int[n];
		int [] arr_two = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr_one[i] = sc.nextInt();
		}
		for(int i=0 ;i<n ; i++) {
			arr_two[i] = sc.nextInt();
		}
		int left = 0;
		while(left < n && arr_one[left] == arr_two[left]) {
			left++;
		}
//		System.out.println(left);
		int right = n-1;
		while(right >= 0 && arr_one[right] == arr_two[right]) {
			right--;
		}
		while(left >= 1 && arr_two[left-1] <= arr_two[left]) {
			left--;
		}
//		System.out.println(left);
		while(right < n-1 && arr_two[right+1] >= arr_two[right]) {
			right++;
		}
		System.out.println((left+1) + " " + (right+1));
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int[] arr_one = new int[n];
		int[] arr_two = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr_one[i] = sc.nextInt();
		}
		for(int i=0 ; i<n ; i++) {
			arr_two[i] = sc.nextInt();
		}
		ArrayList<pair> al = new ArrayList<>();
		int start =-1;
		int end = n-1;
		for(int i=0 ; i<arr_two.length - 1; i++) {
			if(arr_two[i] <= arr_two[i+1]) {
				if(start == -1) {
					start = i;
				}
			}
			else {
				if(start != -1) {
					al.add(new pair(start, i));
//					System.out.println(start + " " + i);
					start = -1;
				}
			}
		}
		if(start != -1) {
			al.add(new pair(start, end));
		}
		HashMap<Integer, Integer> hs1 = new HashMap<>();
		HashMap<Integer, Integer> hs2 = new HashMap<>();

		int ans = Integer.MAX_VALUE;
//		ArrayList<pair> res = new ArrayList<>();
		int ans_one = 0;
		int ans_two = 0;
		int count = 0;
		HashSet<Integer> hs = new HashSet<Integer>();
		for(pair p : al) {
			start = p.a;
			end = p.b;
//			System.out.println(start + " " + end);
			for(int i=start ; i<=end ; i++) {
				int a = arr_one[i];
				int b = arr_two[i];
				hs.add(a);
				hs.add(b);
				if(a == b) {
					if(hs1.size() == 0 && hs2.size() == 0) {
						int diff = ans_two - ans_one;
						if(diff < end - start ) {
							ans_one = start;
							ans_two = end;
						}
						else if(diff == end - start) {
							if(count < hs.size()) {
								ans_one = start;
								ans_two = end;
							}
						}
					}
					continue;
				}
				if(hs1.containsKey(b)) {
					hs1.put(b , hs1.get(b) - 1);
					if(hs1.get(b) == 0) {
						hs1.remove(b);
					}
				}
				else {
					if(hs2.containsKey(b) == false) {
						hs2.put(b, 0);
					}
					hs2.put(b , hs2.get(b) + 1);
				}
				if(hs2.containsKey(a)) {
//					hs2.remove(a);
					hs2.put(a ,  hs2.get(a) - 1);
					if(hs2.get(a) == 0) {
						hs2.remove(a);
					}
				}
				else {
					if(hs1.containsKey(a) == false) {
						hs1.put(a, 0);
					}
					hs1.put(a, hs1.get(a) + 1);
				}
//				System.out.println("------------------");
//				for(int k : hs1) {
//					System.out.print(k + " ");
//				}
//				System.out.println();
//				for(int k : hs2) {
//					System.out.print(k + " ");
//				}
//				System.out.println("------------------");
				if(hs1.size() == 0 && hs2.size() == 0) {
					int diff = ans_two - ans_one;
					if(diff < end - start ) {
						ans_one = start;
						ans_two = end;
					}
					else if(diff == end - start) {
						if(count < hs.size()) {
							ans_one = start;
							ans_two = end;
						}
					}
				}
			}
			hs1.clear();
			hs2.clear();
			hs.clear();
//			System.out.println(ans_one + " " + ans_two);
		}
		System.out.println((ans_one+1) + " " + (ans_two+1));
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
