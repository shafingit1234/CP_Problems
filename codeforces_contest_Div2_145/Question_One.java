package codeforces_contest_Div2_145;

import java.util.HashMap;
import java.util.Scanner;

public class Question_One {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int testcases = sc.nextInt();
		while(testcases > 0) {
			HashMap<Character, Integer> hm = new HashMap<>();
			String str  = sc.next();
			for(int i=0 ; i<str.length() ; i++) {
				if(hm.containsKey(str.charAt(i)) == false) {
					hm.put(str.charAt(i) , 0);
				}
				hm.put(str.charAt(i) , hm.get(str.charAt(i)) + 1);
			}
			if(hm.size() == 4) {
				System.out.println("4");
				
			}
			else if(hm.size() == 1) {
				System.out.println("-1");
//				return ;
			}
			else if(hm.size() == 2) {
				for(char ch : hm.keySet()) {
					if(hm.get(ch) == 2) {
						System.out.println("4");
						break;
					}
					else {
						System.out.println("6");
						break;
					}
				}
			}
			testcases--;
		}
	}
}
