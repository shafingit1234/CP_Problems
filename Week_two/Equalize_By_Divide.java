package Week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Equalize_By_Divide {
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
		long ele;
		int idx;
		pair(long ele, int idx){
			this.ele = ele;
			this.idx = idx;
		}
	}
	public static class ans_pair{
		int a;
		int b;
		ans_pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	public static void findAnswer() {
		int n = sc.nextInt();
		long arr[] = new long[n];
		boolean check = false;
		boolean check_two = false;
		boolean check_three = false;
		for(int i= 0 ;i < n ; i++) {
			arr[i] = sc.nextLong();
			if(arr[i] != 1) {
				check = true;
				if(check_two == true) {
					check_three = true;
				}
			}
			else if(arr[i] == 1) {
				check_two = true;
			}
		}
		if(check == true && check_two == true) {
			check_three =true;
		}
		if(check == false) {
			System.out.println(0);
			return ;
		}
		else if(check_three == true) {
			System.out.println(-1);
			return ;
		}
		ArrayList<pair> al = new ArrayList<>();
		for(int i = 0 ;i<arr.length ; i++) {
			pair p = new pair(arr[i] , i);
			al.add(p);
		}
//		System.out.println("hi");
		my_sort(al);
//		for(pair p : al) {
//			System.out.println(p.ele);
//		}
		ArrayList<ans_pair> res = new ArrayList<>();
//		while(al.get(0).ele != al.get(arr.length-1).ele) {
//			long temp_min = al.get(0).ele;
////			for()
//
//			for(int i=1 ; i<al.size() ; i++) {
//				if(al.get(i).ele != temp_min) {
//					long new_val = (al.get(i).ele + temp_min - 1)/temp_min;
//					int temp_idx = al.get(i).idx;
//					pair p_new = new pair(new_val, temp_idx);
//					al.set(i, p_new);
//					res.add(new ans_pair(temp_idx , al.get(0).idx));
//				}
//			}
//			my_sort(al);
//		}
		for(int j = 0;j < n;j++) {
            long min = al.get(0).ele;
            if(al.get(j).ele != min) {
                while(al.get(j).ele > min) {
                    al.set(j, new pair((al.get(j).ele + min - 1) / min, al.get(j).idx));
                    res.add(new ans_pair(al.get(j).idx, al.get(0).idx));
                }
                if(al.get(j).ele < min) {
//                    Collections.sort(al);
                	my_sort(al);
                    j = -1;
                }
            }
        }
		System.out.println(res.size());
		for(ans_pair p : res) {
			System.out.println((p.a+1) + " "+ (p.b+1));
		}
		
	}
	public static void my_sort(ArrayList<pair> al) {
		Collections.sort(al, new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
//				return 0;
//				return o2.ele - o1.ele;
				if(o2.ele > o1.ele) {
					return -1;
				}
				else if(o2.ele == o1.ele) {
					return Integer.compare(o1.idx , o2.idx);
				}
				return 1;
			}
//			sort on the basis of a.first
//			return b.ele - a.ele;
		});
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
