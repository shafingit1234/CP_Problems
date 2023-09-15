package Rating_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Dominant_Character {
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
		int len = sc.nextInt();
		String str = sc.next();
		//first find out the starting pos of a if it is -1, then return -1
		int start = -1;
		if(len <= 1) {
			System.out.println(-1);
			return;
		}
		for(int i=0 ; i<str.length() ; i++) {
			if(str.charAt(i) == 'a') {
				start = i;
				break;
			}
		}
		if(start == -1) {
			System.out.println(-1);
			return ;
		}
		int count_b = 0;
		int count_c = 0;
		int ans = Integer.MAX_VALUE;
		
		for(int idx = start ; idx < str.length(); idx++) {
			char ch = str.charAt(idx);
			if(ch == 'a') {
				count_b--;
				count_c--;
				if(count_b < 0 && count_c < 0) {
					int diff= Math.abs(idx - start + 1);
					if(diff < 2) {
						continue;
					}
					ans = Math.min(ans, diff);
					int temp = start;
					int temp_b = count_b;
					int temp_c = count_c;
					while(temp < (idx-1)){
						if(str.charAt(temp) == 'a') {
							temp_b++;
							temp_c++;
							if(temp_b < 0 && temp_c < 0) {
								count_b++;
								count_c++;
								temp++;
								continue;
							}
							else {
								break;
							}
						}
						else if(str.charAt(temp) == 'b') {
							count_b--;
						}
						else if(str.charAt(temp) == 'c') {
							count_c--;
						}
						temp++;
					}
					start = temp;
					diff = Math.abs(idx - start + 1);
					ans = Math.min(ans, diff);
				}
				count_b = -1;
				count_c = -1;
				start = idx;
				continue;
			}
			else if(ch == 'b') {
				count_b++;
			}
			else if(ch == 'c') {
				count_c++;
			}
			if(count_b < 0 && count_c < 0) {
				int diff= Math.abs(idx - start + 1);
				if(diff < 2) {
					continue;
				}
				ans = Math.min(ans, diff);
				int temp = start;
				int temp_b = count_b;
				int temp_c = count_c;
				while(temp < (idx-1)){
					if(str.charAt(temp) == 'a') {
						temp_b++;
						temp_c++;
						if(temp_b < 0 && temp_c < 0) {
							count_b++;
							count_c++;
							temp++;
							continue;
						}
						else {
							break;
						}
					}
					else if(str.charAt(temp) == 'b') {
						count_b--;
					}
					else if(str.charAt(temp) == 'c') {
						count_c--;
					}
					temp++;
				}
				start = temp;
				diff = Math.abs(idx - start + 1);
				ans = Math.min(ans, diff);
			}
		}
		if(ans == Integer.MAX_VALUE) {
			ans = seven_check(str);
		}
		System.out.println(ans);
		
		
		
	}
	public static int seven_check(String s){
        if(s.length()<7) return -1;
        int b=0,c=0;
        for(int i=0;i<7;i++){
            if(s.charAt(i) == 'b') b++;
            if(s.charAt(i) == 'c') c++;
        }
        if(b<=2 && c<=2) return 7;
        for(int i=7;i<s.length();i++){
            int left = i-7;
            if(s.charAt(left) == 'b') b--;
            if(s.charAt(left) == 'c') c--;
            if(s.charAt(i) == 'b') b++;
            if(s.charAt(i) == 'c') c++;
            if(b<=2 && c<=2) return 7;
        }
        return -1;
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
//          if(test==2532) System.out.println("Check this out= " + s);
			findAnswer();
		}
	}
}
