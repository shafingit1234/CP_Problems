package Dr_Mostafa_Saad_Ibrahim_Junior_Training_Sheet;

import java.util.ArrayList;
import java.util.Scanner;

public class Win_or_Freeze {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Long> al;
	public static void findPrimes(long num) {
		int temp= 2;
		while(num > 1 && temp <= Math.sqrt(num)) {
			while(num%temp == 0) {
				num = num/temp;
				al.add((long) temp);
			}
			temp++;
		}
		if(num > 1) {
			al.add(num);
		}
		return;
	}
	public static void main(String[] args) {
		al = new ArrayList<Long>();
		long q = sc.nextLong();
		findPrimes(q);
		if(al.size() <= 1) {
			System.out.println(1);
			System.out.println(0);
		}
		if(al.size() == 2) {
			System.out.println(2);
		}
		if(al.size() > 2) {
			System.out.println(1);
			System.out.println(al.get(0)*al.get(1));
		}
		return ;
	}
}
