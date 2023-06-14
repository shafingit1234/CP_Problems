//package Codeforces_educational_contest_150;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Random;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//import Java_CP_Template.Template_One.FastScanner;
//
//public class C {
//	public static FastScanner sc = new FastScanner();
//	public static long mod = (long)(1e9 + 7);
//	public static Long modexp(Long a,Long b)
//    { Long ans=(long)1;
//        while(b>0)
//        {
//          if((b&1)!=0)// b%2!=0
//          {
//              ans=(ans*a)%mod;
//          }
//          a=(a*a)%mod;
//          b=b>>1;  
//        }
//        return ans;
//    }
//	public static int findValue(char ch) {
//		if(ch == 'A') {
//			return 1;
//		}
//		else if(ch == 'B') {
//			return 10;
//		}
//		else if(ch == 'C') {
//			return 100;
//		}
//		else if(ch == 'D') {
//			return 1000;
//		}
//		return 10000;
//	}
//	public static int findSubMax(String str, int[] freq) {
//		char ch = 'A';
//		int idx = -1;
//		for(int i=0 ; i<str.length() ; i++) {
//			String c = ("" + str.charAt(i)).toLowerCase();
//			char temp = c.charAt(0);
//			if(freq[i] != 0) {
//				if(ch <= str.charAt(i)) {
//					ch = str.charAt(i);
//					idx = i;
//				}
//			}
//		}
//		return idx;
//	}
//	public static void findAnswerTwo() {
//		String str = sc.next();
//		int n = str.length();
////		StringBuilder str = new StringBuilder(s);
//		char arr[] = str.toCharArray();
//		char mx_char = arr[n-1];
//		for(int i=n-1 ; i>= 0 ; i--) {
//			arr[i] = mx_char;
//			if(mx_char < str.charAt(i)) {
//				mx_char = str.charAt(i);
//			}
//		}
//		int temp = 0;
//		while(temp < n && str.charAt(temp) == 'E') {
//			temp++;
//		}
//		boolean flag = false;
//		if(temp != n) {
//			int idx = temp;
//			char chrAti = str.charAt(temp);
//			for(int i=temp ; i<n ; i++) {
//				if(str.charAt(i) == 'E') {
//					flag = true;
//					break;
//				}
//				if(str.charAt(i) > chrAti) {
//					chrAti = str.charAt(i);
//					idx = i;
//				}
//			}
//			if(flag == true) {
////				str.charAt(idx) = 'E';
////				str.replace(idx ,idx+1, "" + 'E');
//				str = str.substring(0 , idx) + 'E' + str.substring(idx+2 , str.length());
//			}
//		}
//		else if(flag == false && temp < n) {
//			int idx = temp;
//			char chrAti = str.charAt(temp);
//			while(idx < n && str.charAt(idx) != arr[idx]) {
//				if(chrAti < str.charAt(idx)) {
//					chrAti = str.charAt(idx);
//					temp = idx;
//				}
//				idx++;
//			}
////			str.charAt(temp) = 'E';
////			str.replace(temp, temp+1, "" + 'E');
////			str = str.substring(0 , temp)
//			str = str.substring(0 , temp) + 'E' + str.substring(temp+2 , str.length());
//		}
//		int ans = 0;
//		for(int i=0 ; i<n ; i++) {
//			if(str.charAt(i) < arr[i]) {
//				int val = findValue(str.charAt(i));
//				ans -= val;
//			}
//			else {
//				int val = findValue(str.charAt(i));
//				ans += val;
//			}
//		}
//		System.out.println(ans);
//	}
//	public static void findAnswer() {
//		String str = sc.next();
//		int freq[] = new int[str.length()];
//		Stack<Integer> st = new Stack<>();
//		HashSet<Character> hs =new HashSet<>();
//		boolean flag = false;
//		char mx = 'A';
//		for(int i=0 ; i<str.length() ; i++) {
//			char ch = str.charAt(i);
//			hs.add(ch);
//			if(mx < str.charAt(i)) {
//				mx = ch;
//			}
//			if(st.isEmpty() == true) {
//				st.add(i);
//				continue;
//			}
//			else if(str.charAt(st.peek()) >= str.charAt(i)) {
//				st.push(i);
//				continue;
//			}
//			while(st.isEmpty() == false && str.charAt(st.peek()) < str.charAt(i)) {
//				int id = st.pop();
////				String c = ("" + str.charAt(id)).toLowerCase();
////				char temp = c.charAt(0);
//				freq[id] = 1;
//				flag = true;
//			}
//			st.push(i);
//		}
//		for(int i=0 ; i<str.length() ;i++) {
//			System.out.print(freq[i] + " ");
//		}
//		System.out.println();
//		System.out.println(mx);
//		long value = 0;
//		if(flag == false) {
////			int id = findSecondMax(str);
////			System.out.println(mx);
//			int find_mx = 0;
//			for(int i=0 ; i<str.length() && mx == 'E'; i++) {
//				if(str.charAt(i) == mx) {
//					continue;
//				}
//				if(str.charAt(find_mx) < str.charAt(i)) {
//					find_mx = i;
//				}
//			}
//			boolean check = false;
//			for(int i=0 ; i<str.length(); i++) {
//				if(i == find_mx && mx == 'E') {
//					value += findValue(mx);
//					continue;
//				}
//				else if(mx != 'E' && str.charAt(i) == mx && check == false) {
//					value += findValue('E');
//					check = true;
//					continue;
//				}
//				value += findValue(str.charAt(i));
//			}
//		}
//		else {
////			long sub_value = 0;
//			//find maximum among 0's, change it to possible max.
//			int ch = findSubMax(str, freq);
//			System.out.println(str.charAt(ch));
//			boolean check = false;
////			char mx_char = 'A';
////			for(int i=0 ; i<= ch ; i++) {
////				char t = str.charAt(i);
////				if(mx_char < t) {
////					mx_char = t;
////				}
////			}
////			if(mx_char == str.charAt(ch)) {
////				mx_char = 'E';
////			}
////			System.out.println(mx_char);
//			for(int i=0 ; i<str.length(); i++) {
//				
//				if(freq[i] == 0) {
//					//1000 - 1 - 1 - 1 + 1000  + 1000 + 100 + 1
//					value += findValue(str.charAt(i));
//				}
//				else {
//					if(str.charAt(ch) ==  str.charAt(i) && check == false) {
//						value += findValue(mx_char);
//						check = true;
//					}
//					else {
//						value -= findValue(str.charAt(i));
//					}
//				}
//			}
//		}
//		System.out.println(value);
//		
//	}
//	public static class FastScanner {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer("");
// 
//        String next() {
//            while (!st.hasMoreTokens()) try {
//                st = new StringTokenizer(br.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return st.nextToken();
//        }
// 
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
// 
//        int[] readArray(int n) {
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) a[i] = nextInt();
//            return a;
//        }
// 
//        long nextLong() {
//            return Long.parseLong(next());
//        }
// 
//    }
//	public static final Random random = new Random();
//    public static void ruffleSort(int[] a) {
//        int n = a.length;//shuffle, then sort
//        for (int i = 0; i < n; i++) {
//            int oi = random.nextInt(n), temp = a[oi];
//            a[oi] = a[i];
//            a[i] = temp;
//        }
//        Arrays.sort(a);
//    }
//	public static void main(String[] args) {
//		int tc = sc.nextInt();
////		int tc = 1;
//		while(tc-- > 0) {
//			findAnswer();
////			findAnswerTwo();
//		}
//	}
//}
