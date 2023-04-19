package Week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

//import Java_CP_Template.Template_One.FastScanner;

public class Make_It_Permutation {
//	public static long mod = (long) (1e9 + 7);
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
//	public static Scanner sc_new = new Scanner(System.in);
	public static void findAnswerTwo() {
		int n = sc.nextInt();
	    long c = sc.nextLong();
	    long d = sc.nextLong();
	    
	    TreeSet<Long> set = new TreeSet<>();
	    
	    for(int i=0 ; i<n ; i++){
	        long a = sc.nextLong();
	        set.add(a);
	    }
	    
	    long ans = n*c+d;  // remove all and add 1
	    
	    int i=0;
	    for(long max : set){
	        i++;
	        int remove = n-i;
	        long add = max-i;
	        long cost = remove*c + add*d;
	        ans = Math.min(ans,cost);
	    }
	    System.out.println(ans);
	}
	public static void findAnswer() {
//		Java Not Space Optimized
		int n = sc.nextInt();
////		int cost = sc.nextInt();
		long cost = sc.nextLong();
		long d_cost = sc.nextLong();
		long arr[] = new long[n];
		for(int i = 0 ;i < n ; i++) {
			arr[i] =sc.nextLong();
		}
		
//		Collections.sort(ar)
		Arrays.sort(arr);
		long ans = Integer.MAX_VALUE;
		long remove_cost = n;
		long insert_cost = 0;
		HashSet<Long> hs = new HashSet<>();
		long count = 1;
		for(int i=0 ; i<arr.length ; i++) {
//			long temp = arr[i];
			boolean check = false;
			while(i<arr.length && count == arr[i]) {
				i++;
				check = true;
			}
			if(check == true) {
				i--;
			}
			if(count != arr[i]) {
				insert_cost+= arr[i] - count;
				ans = Math.min(ans, cost*remove_cost + insert_cost*d_cost);
				i--;
//				hs.add(count);
				count = arr[i];
			}
			else {
				remove_cost -= 1;
				ans = Math.min(ans, cost*remove_cost + insert_cost*d_cost);
//				hs.add(count);
			}
			count = arr[i];
			
//			if(count > (arr[arr.length-1])) {
//				break;
//			}
//			if(temp != count + 1) {
//				insert_cost++;
//				ans = Math.min(ans, cost*remove_cost + insert_cost*d_cost);
//				i--;
//				hs.add(count+1);
//				
//			}
//			else {
//				
//				boolean check = false;
//				while(i<arr.length && temp == arr[i]) {
//					i++;
//					check = true;
//				}
//				if(check == true) {
//					i--;				
//				}
//				remove_cost -= 1;
////			ans = Math.min(ans, b)
//				ans = Math.min(ans, cost*remove_cost + insert_cost*d_cost);
////			count++;
//				hs.add(count+1);
//			}
			
			
		}
		System.out.println(ans);
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
//			findAnswerTwo();
		}
	}
}
