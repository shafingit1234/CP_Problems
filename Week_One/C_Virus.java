package Week_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class C_Virus {
	public static FastScanner sc = new FastScanner();
	public static void findAnswer() {
		long n =sc.nextLong();
		int m =sc.nextInt();
//		long temp = sc.nextLong();
		PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
		long infected_peeps[] = new long[m];
		for(int i=0 ; i<m ; i++) {
			infected_peeps[i] = sc.nextLong();
		}
		Arrays.sort(infected_peeps);
		for(int i=0 ; i<m-1 ; i++) {
			long diff = Math.abs(infected_peeps[i+1] - infected_peeps[i] - 1);
			pq.add(diff);
		}
		pq.add(n - infected_peeps[m-1] + infected_peeps[0] - 1);
//		System.out.println(n - infected_peeps[m-1] + infected_peeps[0] - 1);
		long uninfected = 0;
		long temp_infection_attack = 0;
		while(pq.isEmpty() == false) {
			long temp_count = pq.poll() - 2*temp_infection_attack;
//			System.out.println(pq.poll());
			long temp = temp_count - 1;
			if(temp < 0) {
				break;
			}
			else {
				uninfected += temp;
				if(temp == 0) {
					uninfected++;
					break;
				}
			}
//			if(temp_count <=2) {
//				temp_infection_attack++;
//			}
//			else {
//				temp_infection_attack+=2;
//			}
			temp_infection_attack += 2;
		}
		System.out.println(n - (uninfected));
		
	}
	public static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
    }
	public static void main(String[] args) {
		int tc = sc.nextInt();
//		int tc = 1;
		while(tc-- > 0) {
			findAnswer();
		}
	}
}
