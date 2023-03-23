package Math_Codeforces;
import java.util.Scanner;

public class Plant_A {
    public static long power(long N, long M) {
        long power = N, sum = 1;
        while (M > 0) {
            if ((M & 1) == 1) {
                sum = ((sum%mod)*(power%mod))%mod;
            }
            power = ((power%mod) * (power%mod))%mod;
            M = M >> 1;
        }
        return sum%mod;
    }
	public static Scanner sc = new Scanner(System.in);
	public static long mod = 1000000007;
	public static long findAnswer(long a, long n) {
		long ans = 1;
		while(n > 0) {
			if(n%2 == 1) {
				ans = (ans*a)%mod;
			}
			a = (a*a)%mod;
			n = n/2;
		}
		return ans;
	}
	public static void main(String[] args) {
		long n = sc.nextLong();
		//compute 2^i = x- y, compute 4^i = x + y
		long ans = ((power(2, n)%mod + power(4,n)%mod)%mod)/2;
//		return ans;
//		System.out.println((power(2, mod-2)%mod));
		System.out.println(ans);
//		989464295  31966163
	}
}
