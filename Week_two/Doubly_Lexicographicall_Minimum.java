package Week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class Doubly_Lexicographicall_Minimum {
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
		 char ch;
		 int freq;
		 pair(char ch, int freq){
			 this.ch = ch;
			 this.freq= freq;
		 }
	}
	public static void findAnswer() {
		String str = sc.next();
//		String ans = "";
		char ans[] = new char[str.length()];
		int len = str.length();
		int [] freq = new int[26];
		for(int i= 0 ;i<str.length() ; i++) {
			freq[str.charAt(i) - 'a']++;
//			ans += '?';
		}
//		HashMap<, V>
		ArrayList<pair> al = new ArrayList<>();
//		System.out.println(freq[0] + " " + freq[1]);
		for(int i = 0 ; i<26 ; i++) {
			if(freq[i] > 0) {
//				al.add(new pair('a' + i , freq[i]));
				char ch = (char) ('a' + i);
				al.add(new pair((ch) , freq[i]));
			}
		}
		int start= 0;
		int end = len-1;
		for(int i=0 ; i<al.size(); i++) {
			int cnt = al.get(i).freq;
			while(cnt >= 2) {
				//evenly distribute.
//				ans.charAt(i)
				ans[start] = al.get(i).ch;
				start++;
				ans[end] = al.get(i).ch;
				end--;
				cnt-=2;
			}
			if(cnt == 1) {
				if(start == end) {
					ans[start] = al.get(i).ch;
					break;
				}
				else {
					if(i == al.size() - 2) {
//						evenly distribute the last occuring character, place current character in middle.
						int new_cnt = al.get(i+1).freq;
//						System.out.println(new_cnt);
//						System.out.println(start + " " + end);
						
						while(new_cnt >= 2) {
							ans[start++] = al.get(i+1).ch;
//							start++;
							ans[end--] = al.get(i+1).ch;
//							end--;
							new_cnt-=2;
//							System.out.println(new_cnt);
//							System.out.println(start + " " + end);
						}
						if(new_cnt == 1) {
							ans[start] = al.get(i+1).ch;
						}
						ans[end] = al.get(i).ch;
					}
					else {
						//place all greater elements at start, and at the end place the current character.
						for(int j = i+1 ;j<al.size() ; j++) {
							while(al.get(j).freq -- > 0) {
								ans[start++] = al.get(j).ch;
							}
						}
						ans[start] = al.get(i).ch;
					}
					break;
				}
			}

		}
//		System.out.println(ans.toString());
		for(int i=0 ; i<ans.length ; i++) {
			System.out.print(ans[i]);
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
