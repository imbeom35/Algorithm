import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[C+1];
		
		st = new StringTokenizer(br.readLine());
		int cost = Integer.parseInt(st.nextToken());
		int number = Integer.parseInt(st.nextToken());
		for(int i=1; i<=C; i++) {
			dp[i] = ((i-1)/number + 1) * cost;
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cost = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<=C; j++) {
				if(j-number >= 0) {
					dp[j] = Math.min(dp[j], dp[j-number] + cost);
				} else {
					dp[j] = Math.min(dp[j], dp[0] + cost);
				}
			}
		}
		
		System.out.println(dp[C]);
		
		br.close();
	}
}
