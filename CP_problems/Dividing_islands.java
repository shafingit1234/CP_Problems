package CP_problems;

import java.util.Scanner;

public class Dividing_islands {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int a, b, c, d;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		int num = sc.nextInt();
		int[] nums = new int[num];
		//create two grids:
		int[][] gridAB = new int[b][a];
		int[][] gridCD = new int[d][c];
		int i=d-1;
		int p=0;
		while(i>=0) {
			int j=0;
			while(p<num && nums[p] > 0 && j < c) {
				gridCD[i][j] = nums[p]--;
				if(nums[p] == 0) {
					p++;
				}
				j++;
			}
			if(j>=c && p>=num) {
				System.out.println("NO");
				return ;
			}
			j = c-1;
			i--;
			if(i == 0) {
				break;
			}
			while(p<num && nums[p] > 0 && j >=0) {
				gridCD[i][j] = nums[p]--;
				if(nums[p] == 0) {
					p++;
				}
				j--;
			}
			if(j<0 && p>=num) {
				System.out.println("NO");
				return ;
			}
		}
		i = 0;
		while(i < b) {
			int j=a-1;
			while(p<num && nums[p] > 0 && j >=0) {
				gridAB[i][j] = nums[p]--;
				if(nums[p] == 0) {
					p++;
				}
				j--;
			}
			if(j<0 && p>=num) {
				System.out.println("NO");
				return ;
			}
			j = 0;
			i++;
			if(i == b) {
				break;
			}
			while(p<num && nums[p] > 0 && j < a) {
				gridAB[i][j] = nums[p]--;
				if(nums[p] == 0) {
					p++;
				}
				j++;
			}
			if(j >= a&& p>=num) {
				System.out.println("NO");
				return ;
			}
		}
		//find maximum.
		int mx = Math.max(b, d);
		int lt = a + c;
		for(i=0 ; i<mx ; i++) {
			int j=0;
			
			while(i<gridAB.length && j < a) {
				System.out.print(gridAB[i][j]);
				j++;
			}
			if(i >= gridAB.length) {
				while(j < a) {
					System.out.print(".");
					j++;
				}
			}
			j = 0;
			while(i<gridCD.length && j < c) {
				System.out.print(gridCD[i][j]);
				j++;
			}
			if(i >= gridCD.length) {
				while(j < c) {
					System.out.print(".");
					j++;
				}
			}
			System.out.println();
		}
		
	}
}
