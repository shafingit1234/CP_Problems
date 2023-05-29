package Week_Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Weird_Game {
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
		String str1 = sc.next();
		String str2 = sc.next();
		int total_ones_1 = 0;
		int total_ones_2 = 0;
		int common_ones = 0;
		for(int i=0 ; i<str1.length() ; i++) {
			if(str1.charAt(i) == '1') {
				total_ones_1++;
			}
			if(str2.charAt(i) == '1') {
				total_ones_2++;
			}
			if(str1.charAt(i) == '1' && str2.charAt(i) == '1') {
				common_ones++;
			}
		}
		int gained_ones_1 =0;
		int gained_ones_2= 0;
		int turn = 0;
		if(common_ones%2 == 0) {
			gained_ones_1 = common_ones/2;
			gained_ones_2 = common_ones/2;
			turn = 1;
		}
		else {
			gained_ones_1 = (common_ones + 1)/2;
			gained_ones_2 = common_ones - gained_ones_1;
			turn = 2;
		}
		total_ones_1 -= common_ones;
		total_ones_2 -= common_ones;
		while(total_ones_1 > 0 && total_ones_2 > 0) {
			if(turn == 1) {
				total_ones_1--;
				gained_ones_1++;
				turn = 2;
				continue;
			}
			else if(turn == 2) {
				turn = 1;
				total_ones_2--;
				gained_ones_2++;
				continue;
			}
		}
		if(total_ones_1 == 0) {
			if(total_ones_2%2 == 0) {
				gained_ones_2 += (total_ones_2)/2;
			}
			else {
				if(turn == 1) {
					gained_ones_2 += (total_ones_2 - 1)/2;
				}
				else {
					gained_ones_2 += (total_ones_2 + 1)/2;
				}
			}
		}
		else if(total_ones_2 == 0) {
			if(total_ones_1%2 == 0) {
				gained_ones_1 += (total_ones_1)/2;
			}
			else {
				if(turn == 1) {
					gained_ones_1 += (total_ones_1 + 1)/2;
				}
				else {
					gained_ones_1 += (total_ones_1 - 1)/2;
				}
			}
		}
		if(gained_ones_1 == gained_ones_2) {
			System.out.println("Draw");
		}
		else if(gained_ones_1 > gained_ones_2) {
			System.out.println("First");
		}
		else {
			System.out.println("Second");
		}
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
