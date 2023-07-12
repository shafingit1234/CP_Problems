package CP_Practice;

import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import Java_CP_Template.Template_One.FastScanner;

public class sum_of_substring {
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
	public static long computeAnswer(char arr[]) {
		long ans = 0;
//		for(int i=0 ; i<arr.length - 1; i++) {
//			int temp = Integer.parseInt("" + arr[i] + arr[i+1]);
//			ans += temp;
//		}
//		return ans;
		for(int i=1 ; i<arr.length-1 ; i++) {
			int temp = Integer.parseInt("" + arr[i]);
			ans += 11*temp;
		}
		int temp = Integer.parseInt("" + arr[0]);
		ans += 10*temp;
		temp = Integer.parseInt("" + arr[arr.length-1]);
		ans += temp;
		return ans;
	}
	public static void findAnswerTwo() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		String str = sc.next();
		char arr[] = str.toCharArray();
		int ones = 0;
		int first_one = -1;
		int second_one = n;
		for(int i=1 ; i<n-1 ; i++) {
			if(arr[i] == '1') {
				if(first_one == -1) {
					first_one = i;
				}
				second_one = i;
				ones++;
			}
		}
		long ans = 0;
		long res = 0;
		if(k <= 0 || (arr[0] == '1' && arr[n-1] == '1')) {
			ans = computeAnswer(arr);
			System.out.println(ans);
			return ;
		}
		
		if(ones > 0 && (n - second_one - 1) <= k && arr[n-1] == '0') {
			swap(arr, second_one, n-1);
			k -= (n-1-second_one);
			ones = ones-1;
			res += 1;
		}
		if(ones > 0 && (first_one <= k) && arr[0] == '0') {
			swap(arr, first_one, 0);
			res += 10;
			ones = ones - 1;
			k -= (first_one);
		}
		if(arr[0] == '1' && arr[n-1] == '0') {
			if(k >= n-1) {
				swap(arr,0, n-1);
				k -= n-1;
			}
		}
		ans = computeAnswer(arr);
		System.out.println(ans);
//		System.out.println(res + 11*ones);
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		String str = sc.next();
		char arr[] = str.toCharArray();
		if(n == 2) {
			if(arr[0] == '1' && k > 0) {
				//swap arr[0] and arr[1]
				swap(arr, 0, 1);
			}
			long ans = computeAnswer(arr);
			System.out.println(ans);
			return ;
		}
		int start = 0;
		int end = start+1;
		int check = end+1;
		while(check < n && k > 0) {
			if((arr[start] != arr[end]) && arr[end] != '1') {
				//swap check and end
				if(arr[check] == '0')
				{
					swap(arr, end ,check);
					k--;					
				}
			}
			else if((arr[start] == arr[end]) && arr[end] == '1') {
				//swap check and end
				if(arr[check] == '0')
				{
					swap(arr, end ,check);
					k--;					
				}
			}
			start++;
			end++;
			check++;
		}
		long ans = computeAnswer(arr);
		System.out.println(ans);
		return ;
	}
	public static void swap(char arr[] , int start, int end) {
		char temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
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
