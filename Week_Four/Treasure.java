package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Treasure {
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
		String str = sc.next();
		int total_1 = 0;//(
		int total_2 = 0;//) to be inserted 
		int total_3 = 0;//#
		int[] prefix_1 = new int[str.length()+1];
		int[] prefix_2 = new int[str.length()+1];
		for(int i=0 ; i<str.length() ; i++) {
			if(str.charAt(i) == ')') {
				total_2++;
				prefix_2[i+1]= prefix_2[i] + 1; 
				prefix_1[i+1] = prefix_1[i];
			}
			else if(str.charAt(i) == '(') {
				total_1++;
				prefix_1[i+1] = prefix_1[i] + 1;
				prefix_2[i+1] = prefix_2[i];
			}
			else if(str.charAt(i) == '#') {
				total_3++;
				prefix_1[i+1] = prefix_1[i];
				prefix_2[i+1] = prefix_2[i] + 1;
			}
		}
		
		total_2 += total_3;
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(total_1 < total_2) {
			System.out.println(-1);
			return ;
		}
//		System.out.println(prefix_1[str.length()] + " " + prefix_2[str.length()]);
		int to_add = prefix_1[str.length()] - prefix_2[str.length()];
//		int cnt = 1;
//		1 - (
//		2 - ) to be inserted 
//		3 - #
		for(int i=0 ; i<str.length(); i++) {
			if(str.charAt(i) == '#') {
				if(prefix_1[i+1] < prefix_2[i+1]) {
					System.out.println(-1);
					return ;
				}
				else if(prefix_1[i+1] == prefix_2[i+1]) {
					al.add(1);
				}
				else {
					int cnt = 0;
					while(prefix_1[i+1] > prefix_2[i+1]) {
						if(to_add > 0) {
							to_add = to_add - 1;
							prefix_2[i+1] += 1;
							cnt++;
						}
						else if(to_add <= 0) {
							break;
						}
					}
					al.add(1 + cnt);
				}
			}
		}
		if(to_add > 0) {
			System.out.println(-1);
			return ;
		}
		for(int i : al) {
			System.out.println(i);
		}
		
	}
	public static void findAnswerTwo() {
		String str = sc.next();
		int len = str.length();
		int cnt = 0;
		int diff = 0;
		for(int i=0 ; i<len ; i++) {
			if(str.charAt(i) == '#') cnt++;
			else if(str.charAt(i) == '(') diff++;
			else diff--;
			if(diff < 0) {
//				break;
				System.out.println(-1);
				return ;
			}
		}
		if(diff < cnt) {
			System.out.println(-1);
			return ;
		}
		int res = 0;
		Stack<Character> st = new Stack<>();
		int curr = 1;
		for(int i=0 ; i<len ; i++) {
			if(str.charAt(i) == '(') {
				st.push('(');
			}
			if(str.charAt(i) == '#' && st.isEmpty()== true) {
//				break;
				System.out.println(-1);
				return ;
			}
			if(str.charAt(i) == ')' && st.isEmpty() == true) {
//				break;
				System.out.println(-1);
				return ;
			}
			if(str.charAt(i) == '#') {
				if(curr != cnt) {
					st.pop();
					diff--;
					curr++;
				}
				else {
					while(st.isEmpty() == false && diff > 0) {
						st.pop();
						diff--;
						res++;
					}
					if(diff != 0) {
//						break;
						System.out.println(-1);
						return ;
					}
				}
			}
			else if(str.charAt(i) == ')') {
				st.pop();
			}
		}
		if(st.isEmpty() == false || diff > 0) {
			System.out.println(-1);
			return ;
		}
		for(int i=1; i<cnt ; i++) {
			System.out.println(1);
		}
		System.out.println(res);
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
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
}
