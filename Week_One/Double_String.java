package Week_One;

import java.util.HashSet;
import java.util.Scanner;

public class Double_String {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		String arr[] = new String[n];
		HashSet<String> hs = new HashSet<>();
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.next();
			hs.add(arr[i]);
		}
//		create all possible substrings
		int ans[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			for(int j = 1; j<arr[i].length() ; j++) {
				String first = arr[i].substring(0 , j);
				String second =arr[i].substring(j);
				if(hs.contains(first) == true && hs.contains(second) == true) {
					ans[i]= 1;
					break;
				}
			}
			System.out.print(ans[i]);
		}
	System.out.println();
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
