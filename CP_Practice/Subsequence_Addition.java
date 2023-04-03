package CP_Practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Subsequence_Addition {
	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
//		Arrays.sort(arr);
		ruffleSort(arr);
		if(arr[0]!=1) {
            System.out.println("NO");
            return;
        }
        long currEnd=1;
        int i=1;
        for (i = 1; i < n; i++) {

            if(arr[i]>currEnd) break;
            currEnd+=arr[i];
        }
        if(i==n) System.out.println("YES");
        else System.out.println("NO");
	}
	static final Random random = new Random();
	 
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
