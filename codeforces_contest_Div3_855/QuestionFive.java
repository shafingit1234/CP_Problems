package codeforces_contest_Div3_855;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class QuestionFive {
	public static String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();
 
        // Sorting temp array using
        Arrays.sort(tempArray);
 
        // Returning new sorted string
        return new String(tempArray);
    }
	public static Scanner sc = new Scanner(System.in);
	public static boolean check(String str1, String str2) {
		int[] arr = new int[26];
		
		for(int i=0 ; i<str1.length(); i++) {
			arr[str1.charAt(i) - 97]++;
		}
		for(int i=0 ; i<str2.length(); i++) {
			arr[str2.charAt(i) - 97]--;
		}
		for(int i=0 ; i<26 ; i++) {
			if(arr[i] != 0) {
				return false;
			}
		}
		return true;
		
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int i=0;
		while(i < testcase) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String str1 = sc.next();
			String str2 = sc.next();
			if(check(str1, str2) == false) {
				System.out.println("NO");
				i++;
				continue;
			}
			boolean flag = true;
			for(int j=0 ; j<Math.min(n, k) ; j++) {
				while(n-1-j > k) {
					j++;
				}
				if(n-1-j < k) {
					if(str1.charAt(j) != str2.charAt(j)) {
						System.out.println("NO");
						flag = false;
						break;
					}
				}
			}
			if(flag == false) {
				i++;
				continue;
			}
			System.out.println("YES");
			i++;
		}
	}
}
