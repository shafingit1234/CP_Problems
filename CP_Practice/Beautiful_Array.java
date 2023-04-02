package CP_Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Beautiful_Array {
	public static void findAnswer() {
		long n = sc.nextLong();
		long k = sc.nextLong();
		long b = sc.nextLong();
		long s = sc.nextLong();
		int temp = 1;
		while(temp <= k) {
			long chck = (b+1)*k - temp;
			
			if(chck <= s) {
				break;
			}
			temp++;
		}
		long last = (b+1)*k - temp;
		long remain = s - last;
		if(n-1 == 0) {
			if(last == s) {
				System.out.println(last);
			}
			else {
				System.out.println(-1);
			}
			return ;
		}
		if(temp > k || Math.ceil(remain/(n-1)) >= k) {
			System.out.println(-1);
			return ;
		}
		ArrayList<Long> al = new ArrayList<>();
		al.add(last);
		long ele = n-1;
		long rem = (long)Math.ceil(remain/(n-1));
		long fill = k - 1;
		System.out.println(remain + " " + rem);
		for(long i=ele ; i>=1; i--) {
//			if(remain < rem) {
//				remain = rem;
//			}
//			al.add(rem);
//			remain = remain - rem;
//			if(remain == 0) {
//				break;
//			}
//			al.add(remain);
			if(remain < fill) {
				remain = fill;
				al.add(fill);
				remain = 0;
			}
			else if(remain >= fill) {
				remain = remain - fill;
			}
			
			if(remain == 0) {
				break;
			}
		}
		int cnt = al.size();
		while(cnt != n) {
			al.add(0l);
			cnt++;
		}
		Collections.reverse(al);
		for(long i : al) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
