import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		LIS(0);
		
		System.out.println(ans+1);
		
		br.close();
	}
	
	static void LIS(int n){
		if(n == N) {
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(arr[i] < arr[n] && dp[n] < dp[i]+1) {
				dp[n] = dp[i]+1;
			}
		}
		
		ans = Math.max(ans, dp[n]);
		
		LIS(n+1);
	}
}
