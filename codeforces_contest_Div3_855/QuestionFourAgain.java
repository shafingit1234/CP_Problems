package codeforces_contest_Div3_855;

import java.util.HashSet;
import java.util.Scanner;

public class QuestionFourAgain {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int i=0;
		
		while(i < testcase) {
			int len = sc.nextInt();
			StringBuilder sb = new StringBuilder("");
			sb.append("" + sc.next());
			//all possible answer.
			int ans = sb.length()-1;
			for(int j=1 ; j<len-1 ; j++) {
//				char ch = sb.charAt(j);
				if(sb.charAt(j-1) == sb.charAt(j+1)) {
					//delete duplicate answer.
					ans--;
				}
			}
			i++;
			System.out.println(ans);
//			sb.delete(0, sb.length()-1);
		}
	}
}
