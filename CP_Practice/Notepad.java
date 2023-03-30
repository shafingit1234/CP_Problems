package CP_Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Notepad {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		String s = sc.next();
		HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
		for(int i=0 ; i<s.length() ; i++) {
			if(hm.containsKey(s.charAt(i)) == false) {
				hm.put(s.charAt(i) , new ArrayList<Integer>());
			}
			else {
				if(i+1 < s.length()) {
					for(int j : hm.get(s.charAt(i))) {
						if(j+1 < s.length() && hm.containsKey(s.charAt(j+1)) == true) {
							if(s.charAt(j+1) == s.charAt(i+1) && j+1 != i) {
								System.out.println("YES");
								return ;
							}
						}
					}
				}
			}
			hm.get(s.charAt(i)).add(i);
		}
		System.out.println("NO");
		return ;
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
