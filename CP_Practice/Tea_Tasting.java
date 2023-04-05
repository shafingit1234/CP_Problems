package CP_Practice;

import java.util.Scanner;

public class Tea_Tasting {
	public static int check(int[] pre, int i, int val) {
		int ans = -1;
		int start = i;
		int end = pre.length-1;
		int low = start;
		while(low <= end) {
			int mid = low + (end - low)/2;
			if(pre[mid] - pre[start] <= val) {
				ans = mid;
				low = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return ans;
	}
	public static Scanner sc = new Scanner(System.in);
	public static void findAnswer() {
		int n = sc.nextInt();
		int tea[] = new int[n+1];
		int tasters[] = new int[n+1];
		for(int i=1 ; i<=n ; i++) {
			tea[i] = sc.nextInt();
		}
		int prefix[] = new int[n+1];
		int full[] = new int[n+2];
		long ans[] = new long[n+2];
//		prefix[0] = 0;
		for(int i=1 ; i<=n ; i++) {
			tasters[i] = sc.nextInt();
			prefix[i] = tasters[i]+ prefix[i-1];
		}
		for(int i=1 ; i<=n ; i++) {
			long val = tea[i];
			int start = i;
			int end = n;
			while(start +1< end) {
				int mid = start + (end - start)/2;
				if(prefix[mid] - prefix[i-1]> val) {
					start = mid;
				}
				else {
					end = mid;
				}
			}
			if(prefix[end] - prefix[i-1]<= val) {
				full[i]++;
				full[end+1]--;
				ans[end+1] += tea[i] - (prefix[end] - prefix[i-1]);
			}
			else if(prefix[start] - prefix[i-1]<=val) {
				full[i]++;
				full[start+1]--;
				ans[start+1] += tea[i] - (prefix[start] - prefix[i-1]);
			}
			else {
				ans[start] += tea[i] - (prefix[start-1] - prefix[i-1]);
			}
		}
		for(int i=1 ; i<= n ;i++) {
			full[i] += full[i-1];
			ans[i] += 1L*full[i]*tasters[i];
		}
		for(int i=1 ; i<=n ; i++) {
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
