import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[2][n+1];
			
			int[][] dp = new int[2][n+1];
			int ans = 0;
			
			for(int y=0; y<2; y++) {
				String[] input = br.readLine().split(" ");
				for(int x=1; x<=n; x++) {
					arr[y][x] = Integer.parseInt(input[x-1]);
				}
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for(int x=2; x<=n; x++) {
				dp[0][x] = Math.max(dp[1][x - 1], dp[1][x - 2]) + arr[0][x];
				dp[1][x] = Math.max(dp[0][x - 1], dp[0][x - 2]) + arr[1][x];
			}
			
			ans = Math.max(dp[0][n], dp[1][n]);
			
			System.out.println(ans);
		}
	}
}
