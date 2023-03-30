package CP_Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Koxia_and_Whiteboard {
	public static Scanner sc = new Scanner(System.in);
	public static int mod = 1000000007;
	public static void findAnswerTwo() {
//		int n=sc.nextInt();
//		int m =sc.nextInt();
//		long n_arr[] = new long[n + m-1];
////		long m_arr[] = new long[m];
//		for(int i =0;i<n+m -1; i++) {
//			n_arr[i] = sc.nextInt();
////			System.out.print(n_arr[i] + " ");
//		}
//		System.out.println();
//		
//		Arrays.sort(n_arr);
////		Arrays.sort(m_arr);
//		int end = n_arr.length-1;
//		long sum = 0;
//		for(int i=0 ; i<n-1 ; i++) {
//			sum = sum + n_arr[end--];
//		}
//		System.out.println(sum);
		int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] a = new Integer[n + m - 1];
        for(int i = 0;i < n + m - 1;i++)
            a[i] = sc.nextInt();
        Arrays.sort(a, Collections.reverseOrder());
        long sum = sc.nextInt();
        for(int i = 0;i < n - 1;i++)
            sum += a[i];
        System.out.println(sum);
		return ;
	}
	public static void findAnswer() {
		int n=sc.nextInt();
		int m =sc.nextInt();
		long n_arr[] = new long[n];
		long m_arr[] = new long[m];
		for(int i =0;i<n ; i++) {
			n_arr[i] = sc.nextInt();
		}
		for(int i=0 ; i<m ; i++) {
			m_arr[i] = sc.nextInt();
		}
		Arrays.sort(n_arr);
		Arrays.sort(m_arr);
		long sum = 0;
		int start = n_arr.length-1;
		int end= m_arr.length -1;
		while(end >= 0 && start >=0) {
			sum =(sum + m_arr[end]);
			end--;
			start--;
		}
		while(start >= 0) {
			sum = (sum + n_arr[start]);
			start--;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
}
