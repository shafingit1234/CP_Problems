package CP_Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutation {
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int seq = sc.nextInt();
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		int ans[]= new int[seq];
		int freq[] = new int[seq+1];
		for(int i=0 ; i<seq ; i++) {
			al.add(new ArrayList<>());
		}
		for(int i=0 ; i<seq ; i++) {
			for(int j=0 ; j<seq-1 ; j++) {
				al.get(i).add(sc.nextInt());
				if(j == 0) {
					freq[al.get(i).get(j)]++;
				}
			}
		}
		for(int i=1 ; i<freq.length ; i++) {
			if(freq[i] == seq-1) {
				ans[0] = i;
				break;
			}
		}
		int k = 1;
		for(int i=0 ; i<seq ; i++) {
			if(al.get(i).get(0) != ans[0]) {
				for(int j = 0 ;j<seq-1 ; j++) {
					ans[k++] = al.get(i).get(j);
				}
				break;
			}
		}
		for(int i=0 ; i<ans.length; i++) {
			System.out.print(ans[i] + " ");
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
