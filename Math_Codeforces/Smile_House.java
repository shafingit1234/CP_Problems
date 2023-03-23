package Math_Codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Smile_House {
	public static Scanner sc = new Scanner(System.in);
	public static int[][] temp ;
	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		//create graph
		int costs[][] = new int[n][n];
		for(int i=0; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(i == j) continue;
				costs[i][j] = Integer.MIN_VALUE;
			}
		}
		for(int i=0 ; i<m ; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			costs[u][v] = sc.nextInt();
			costs[v][u] = sc.nextInt();
		}
		int compute[][][] = new int[(30)][n][n];
		compute[0] = costs;
		for(int i=1 ; i<(30) ; i++) {
			compute[i] = computeCosts(compute[i-1] , compute[i-1]);
		}
		//now find minimum nodes required to be present in a cycle resulting in positive distance for every node to node commute.
		int low = 1;
		int high= n+1;
		int ans =0;
		temp = new int[n][n];
		for(int x[] : temp) {
			Arrays.fill(x, Integer.MIN_VALUE);
		}
		for(int i=0 ; i<temp.length ; i++) {
			temp[i][i] = 0;
		}
		
		while(low <=high) {
			int mid = low + (high - low)/2;
			if(valid(mid , compute)) {
				ans = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		System.out.println(ans);
	}
	public static boolean valid(int mid, int[][][]compute) {
		int[][] res = temp;
		for(int i = 0 ;i<30 ; i++) {
			if((mid & (1 << i)) != 0) {
				res = computeCosts(res , compute[i]);
			}
		}
		for(int i=0 ; i<res.length; i++) {
			if(res[i][i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static int[][] computeCosts(int[][] reference , int[][] current){
		int[][] res = new int[reference.length][current[0].length];
		for(int[]x : res) {
			Arrays.fill(x, Integer.MIN_VALUE);
		}
		for(int i=0 ; i<reference.length ; i++) {
			for(int j=0 ; j<current.length ; j++) {
				for(int k=0 ; k<current[0].length ; k++) {
					res[i][k] = Math.max(reference[i][j] + current[j][k], res[i][k]);
				}
			}
		}
		return res;
	}
}
