package Week_One;

//import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//import Java_CP_Template.Template_One.FastScanner;

public class Two_Interval {
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
	public static class pair {
		long num;
		String cat;
		pair(long num, String cat){
			this.num = num;
			this.cat = cat;
		}
	}
	public static void findAnswerTwo() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int m = Math.max(a, c);
		int n  =Math.min(b,d);
		if(m > n) {
			System.out.println(-1);
			return ;
		}
		else {
			System.out.println(m + " " + n);
		}
	}
	public static void findAnswer() {
		List<pair> al = new ArrayList<>();
		String cat[] = new String[4];
		cat[0] = "l_one";
		cat[1] = "r_one";
		cat[2] = "l_two";
		cat[3] = "r_three";	
		boolean check = true;
		for(int i=0 ; i<4 ; i++) {
			long temp = sc.nextLong();
			if(i != 0 && temp != al.get(i-1).num) {
				check = false;
			}
			al.add(new pair(temp , cat[i]));
		}
		if(check == true) {
			System.out.println(al.get(0).num + " " + al.get(0).num);
			return ;
		}
		if(al.get(0).num == al.get(1).num && al.get(0).num == al.get(1).num) {
			System.out.println(al.get(1).num + " " + al.get(2).num);
			return ;
		}
		if(al.get(1).num == al.get(2).num && al.get(1).num == al.get(3).num) {
			System.out.println(al.get(1).num + " " + al.get(2).num);
			return ;
		}
		Collections.sort(al , new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
//				return 0;
//				return (int)o1.num - o2.num;
				if(o1.num > o2.num) {
					return 1;
				}
				return -1;
			}
		});
//		for(pair p : al) {
//			System.out.println(p.num);
//		}
		String str_one = al.get(0).cat;
		String str_two = al.get(1).cat;
		String str_three = al.get(2).cat;
		String str_four  =al.get(3).cat;
		long ans_one = 0;
		long ans_two = 0;
		if(str_one.equals("l_one") && str_two.equals("l_two") && str_three.equals("r_two")) {
//			System.out.println();
			ans_one = al.get(1).num;
			ans_two = al.get(2).num;
		}
		else if(str_one.equals("l_one") && str_two.equals("l_two") && str_three.equals("r_one")) {
			ans_one = al.get(1).num;
			ans_two = al.get(2).num;
		}
		else if(str_one.equals("l_two") && str_two.equals("l_one") && str_three.equals("r_two")) {
			ans_one = al.get(1).num;
			ans_two = al.get(2).num;
		}
		else if(str_one.equals("l_two") && str_two.equals("l_one") && str_three.equals("r_one")) {
			ans_one = al.get(1).num;
			ans_two = al.get(2).num;
		}
		else if(str_one.equals("l_two") && str_two.equals("l_one") && str_three.equals("l_two")) {
			ans_one = al.get(1).num;
			ans_two = al.get(2).num;
		}
		else if(str_one.equals("l_one") && str_two.equals("l_two") && str_three.equals("r_one")) {
			ans_one = al.get(1).num;
			ans_two = al.get(2).num;
		}
		else {
			System.out.println(-1);
			return ;
		}
		System.out.println(ans_one + " " + ans_two);
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
//		int tc = sc.nextInt();
		int tc = 1;
		while(tc-- > 0) {
//			findAnswer();
			findAnswerTwo();
		}
	}
}
