import java.io.*;
import java.util.*;

public class Main {
	
	private static final long MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		long ans = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long S = Long.parseLong(st.nextToken());
			
			long gcd = gcd(N, S);
			N /= gcd;
			S /= gcd;
			
			ans += S * pow(N, MOD - 2) % MOD;
			ans %= MOD; 
		}
		
		System.out.println(ans);
		
		br.close();
	}
	
	private static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		
		return gcd(b, a % b);
	}
	
	private static long pow(long n, long exp) {
		if(exp == 1) {
			return n;
		}
		
		if(exp % 2 == 1) {
			return n* pow(n, exp - 1) % MOD;
		} else {
			long temp = pow(n, exp / 2);
			return temp * temp % MOD;
		}
	}
}
