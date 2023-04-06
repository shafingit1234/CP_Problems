package Codeforces_Edu_146;

import java.util.ArrayList;
import java.util.Scanner;

public class Question_B {
	public static ArrayList<Integer> f_a;
	public static ArrayList<Integer> f_b;
	public static void printDivisors(int n , ArrayList<Integer>f)
	{ int i;
	    for( i = 1; i * i < n; i++)
	    {
	        if (n % i == 0)
	        	f.add(i);
//	            System.out.print(i + " ");
	    }
	    if(i-(n/i)==1)
	    {
	      i--;
	    }
	    for(; i >= 1; i--)
	    {
	        if (n % i == 0)
//	            System.out.print(n / i + " ");
	        	f.add(n/i);
	    }
//	    System.out.println();
	}
	public static void findAnswer() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		f_a = new ArrayList<Integer>();
		f_b = new ArrayList<Integer>();
		printDivisors(a, f_a);
		printDivisors(b ,f_b);
		int start = 0;
		int steps = 1;
		if(a > b) {
			ArrayList<Integer> tmp = f_a;
			f_a = f_b;
			f_b = tmp;
			int temp = a;
			a = b;
			b= temp;
		}
		int res = Integer.MAX_VALUE;
		int end = f_a.size()-1;
//		System.out.println();
		while(start <= end) {
			int ans = 0;
//			int mid = start + (end - start)/2;
			int temp = f_a.get(start);
			steps = temp;
			ans += (temp - 1) + (a/steps);
//			System.out.print(temp + " ");
			int next_start = 0;
			int next_end = f_b.size()-1;
			int where_to_Start = findEle(f_b , temp);
//			System.out.println(f_b.get(where_to_Start));
			next_start = where_to_Start;
			while(next_start <= next_end) {
//				int next_mid = next_start + (next_end - next_start)/2;
				int next_temp = f_b.get(next_start);
				int store = ans;
				ans += (next_temp - steps) + (b/next_temp);
				int t = res;
				res = Math.min(res,  ans);
				next_start++;
				ans = store;
			}
			
			start++;
		}
		System.out.println(res);
	}
	public static int findEle(ArrayList<Integer> f, int temp) {
		int start = 0;
		int end = f.size()-1;
		int ans = -1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(f.get(mid) >= temp) {
				ans = mid;
				end =mid-1;
			}
			else {
//				ans = mid;
				start = mid+1;
			}
		}
		if(ans == -1) {
			return f.size()-1;
		}
		return ans;
	}
	public static void findAnswerTwo() {
		long x = sc.nextLong(), y = sc.nextLong();
	    long ans = Long.MAX_VALUE;
	    for(long i = 1; i <= 100000; i++) {
	    	ans = Math.min(ans, i - 1 + (x + i - 1) / i + (y + i - 1) / i);
	    }
	    System.out.println(ans);
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
}
