package CP_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Koxia_And_Number_Theory {
	public static FastScanner sc = new FastScanner();
	public static long mod = (long)(1e9 + 7);
	public static Long modexp(Long a,Long b)
    { Long ans=(long)1;
        while(b>0)
        {
          if((b&1)!=0)// b%2!=0
          {
              ans=(ans*a)%mod;
          }
          a=(a*a)%mod;
          b=b>>1;  
        }
        return ans;
    }
	public static class pair{
		int a;
		int b;
		pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	public static void findAnswerThree(ArrayList<Integer> primes) {
		int n = sc.nextInt();
		Long arr[] = new Long[n];
		HashSet<Long> hs = new HashSet<>();
		boolean check = false;
		//code to check whether all elements are distinct or not.
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
//			hs.add(arr[i]);
			if(hs.contains(arr[i]) == true) {
				check = true;
			}
			hs.add(arr[i]);
		}
		if(check == true) {
			System.out.println("NO");
			return ;
		}
		for(int i=0 ; i<primes.size() ; i++) {
			int p = primes.get(i);
			int rem_freq[] = new int[p];
			for(long ele : arr) {
				rem_freq[(int) (ele%p)]++;
			}
			int mn = Integer.MAX_VALUE;
			for(int j = 0 ; j<rem_freq.length ; j++) {
				mn = (int) Math.min(mn, rem_freq[j]);
			}
			if(mn >= 2) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		return ;
	}
	public static void findAnswerTwo(ArrayList<Integer> primes) {
		int n = sc.nextInt();
		long arr[] = new long[n];
		HashSet<Long> hs = new HashSet<>();
		boolean check = false;
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextLong();
//			hs.add(arr[i]);
			if(hs.contains(arr[i]) == true) {
				check = true;
			}
			hs.add(arr[i]);
		}
		if(check == true) {
			System.out.println("NO");
			return ;
		}
		
		HashMap<Long, Long> hm = new HashMap<>();
		for(int i=0 ; i<arr.length ; i++) {
			for(int j : primes) {
				long rem = arr[i]%j;
				if(hm.containsKey(rem) == false) {
					hm.put(rem, (long) 0);
				}
				hm.put(rem, hm.get(rem) + 1);
				if(hm.get(rem) > 1) {
					System.out.println("NO");
					return ;
				}
			}
		}
		System.out.println("YES");
		return ;
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
//		HashMap<pair, ArrayList<Integer>> hm = new HashMap<>();
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		for(int i=0 ; i<n ; i++) {
			for(int j = i+1 ; j<n ; j++) {
//				pair p = new pair(arr[i] , arr[j]);
				al.add(new ArrayList<Integer>());
				long  a = arr[i];
				long  b = arr[j];
				
				for(int k=1 ; k < 1001 ; k++) {
					long temp_a = a+ k;
					long temp_b = b+ k;
					if(temp_a%temp_b == 0 || temp_b%temp_a == 0) {
						continue;
					}
					if(gcd(temp_a, temp_b) == 1) {
						al.get(al.size()-1).add(k);
					}
				}
			}
		}
		if(al.size() == 1) {
			if(al.get(0).size() > 0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			return ;
		}
		else if(al.size() == 0) {
			System.out.println("NO");
			return ;
		}
		ArrayList<Integer> common = findCommon(al.get(0) , al.get(1));
		if(common.size() == 0) {
			System.out.println("NO");
			return ;
		}
		for(int i=2 ; i<al.size() ; i++) {
			common = findCommon(al.get(i) , common);
			if(common.size() == 0) {
				System.out.println("NO");
				return ;
			}
		}
		System.out.println("YES");
		return ;
	}
	public static ArrayList<Integer> findCommon(ArrayList<Integer> ls_one , ArrayList<Integer> ls_two){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while(i < ls_one.size() && j < ls_two.size()) {
			if(ls_one.get(i) == ls_two.get(j)) {
				if(temp.isEmpty() == false && temp.get(temp.size()-1) == ls_one.get(i)) {
					i++;
					j++;
				}
				temp.add(ls_one.get(i));
				i++;
				j++;
			}
			else if(ls_one.get(i) < ls_two.get(j)) {
				i++;
			}
			else {
				j++;
			}
		}
		return temp;
	}
	public static long gcd(long n1, long n2) {
	    if (n2 == 0) {
	        return n1;
	    }
	    return gcd(n2, n1 % n2);
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
	public static final Random random = new Random();
    public static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    public static ArrayList<Integer> calculatePrimes(int n) {
    	boolean[] primes = new boolean[n+1];
    	Arrays.fill(primes, true);
    	primes[0] = false;
    	primes[1] = false;
//    	primes[2] = true;
    	for(int i=2 ; i<=Math.sqrt(n); i++) {
    		if(primes[i] == false) {
    			continue;
    		}
    		for(int j = i+i ; j<n ; j+=i) {
    			primes[j] = false;
    		}
    	}
    	ArrayList<Integer> primes_list = new ArrayList<>();
    	for(int i=0 ; i<=n ; i++) {
    		if(primes[i]  == true) {
    			primes_list.add(i);
    		}
    	}
    	return primes_list;
    }
	public static void main(String[] args) {
		int tc = sc.nextInt();
//		int tc = 1;
		ArrayList<Integer> primes = calculatePrimes(10000);
		while(tc-- > 0) {
//			findAnswer();
//			findAnswerTwo(primes);
			findAnswerThree(primes);
		}
	}
}
