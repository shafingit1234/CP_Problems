package codeforces_contest_Div3_855;

import java.util.HashSet;
import java.util.Scanner;

public class QuestionFour {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int i=0;
		HashSet<String> hs = new HashSet<>();
		StringBuilder sb = new StringBuilder("");
		StringBuilder temp = new StringBuilder("");
		while(i < testcase) {
			int len = sc.nextInt();
			sb.append("" + sc.next());
			for(int j=0 ; j<len-1 ; j++) {
				
//				String str = "" ;
				if(j+2 == len) {
//					str = sb.substring(0, j);
					temp.append("" + sb.substring(0,j));
				}
				else temp.append("" + sb.substring(0, j) + sb.substring(j+2 , len));
				if(hs.contains(temp.toString()) == false) {
					hs.add(temp.toString());
				}
				temp.delete(0, temp.length());
			}
			System.out.println(hs.size());
			hs.clear();
			sb.delete(0, len);
			i++;
		}
	}
}
