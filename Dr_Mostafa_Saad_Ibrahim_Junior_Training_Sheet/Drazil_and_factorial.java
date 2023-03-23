package Dr_Mostafa_Saad_Ibrahim_Junior_Training_Sheet;

import java.util.HashMap;
import java.util.Scanner;

public class Drazil_and_factorial {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		String str = sc.next();
		HashMap<Integer, Integer> hm = new HashMap<>();
		int mx = 0;
		for(int i=0 ; i<str.length() ; i++) {

			int j = str.charAt(i)-'0';
//			mx= Math.max(mx,  j);
			if(j == 0 || j == 1) {
				continue;
			}
			if(j == 2) {
				if(hm.containsKey(2) == false) {
					hm.put(2, 0);
				}
				hm.put(2, hm.get(2)+1);
				mx = Math.max(2, mx);
			}
			if(j == 3) {
				if(hm.containsKey(3) == false) {
					hm.put(3, 0);
				}
				hm.put(3, hm.get(3)+1);
				mx = Math.max(3, mx);
			}
			if(j == 4) {
				if(hm.containsKey(2) == false) {
					hm.put(2, 2);
				}
				else hm.put(2, hm.get(2) + 2);
				if(hm.containsKey(3) == false) {
					hm.put(3,1);
				}
				else hm.put(3, hm.get(3) + 1);
				mx = Math.max(3, mx);
			}
			if(j == 5) {
				if(hm.containsKey(5) == false) {
					hm.put(5, 0);
				}
				hm.put(5, hm.get(5)+1);
				mx = Math.max(5, mx);
			}
			if(j == 6) {
				if(hm.containsKey(5) == false) {
					hm.put(5, 0);
				}
				hm.put(5, hm.get(5)+1);
				if(hm.containsKey(3) == false) {
					hm.put(3,1);
				}
				else hm.put(3, hm.get(3) + 1);
				mx = Math.max(5, mx);
			}
			if(j == 7) {
				if(hm.containsKey(7) == false) {
					hm.put(7,0);
				}
				hm.put(7, hm.get(7) + 1);
				mx = Math.max(7, mx);
			}
			if(j == 8) {
				if(hm.containsKey(2) == false) {
					hm.put(2, 0);
				}
				hm.put(2, hm.get(2)+3);
				if(hm.containsKey(7) == false) {
					hm.put(7,0);
				}
				hm.put(7, hm.get(7) + 1);
				mx = Math.max(7, mx);
			}
			if(j == 9) {
				if(hm.containsKey(2) == false) {
					hm.put(2, 0);
				}
				hm.put(2, hm.get(2)+1);
				if(hm.containsKey(7) == false) {
					hm.put(7,0);
				}
				hm.put(7, hm.get(7) + 1);
				if(hm.containsKey(3) == false) {
					hm.put(3, 0);
				}
				hm.put(3, hm.get(3)+2);
				mx = Math.max(7, mx);
			}
		}
		
//		System.out.println(mx);
//		System.out.println(hm.get(7));
		for(int i=mx ; i>1 ; i--) {
			if(hm.containsKey(i) == true) {
				while(hm.get(i) > 0) {
					System.out.print(i);
					hm.put(i , hm.get(i)-1);
				}
			}
		}
		
		return ;
		
	}
}
