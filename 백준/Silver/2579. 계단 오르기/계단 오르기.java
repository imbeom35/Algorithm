import java.io.*;

public class Main {
	static int stairs[];
	static Integer dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		stairs = new int[N+1];
		dp = new Integer[N+1];
		
		for(int i=1; i<N+1; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = stairs[0];
		dp[1] = stairs[1];
		if(N >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}
		
		System.out.println(back_step(N));
		
		br.close();
	}
	
	public static int back_step(int N) {
		if(dp[N] == null) {
			dp[N] = Math.max(back_step(N-2), back_step(N-3) + stairs[N-1]) + stairs[N];
		}
		
		return dp[N];
	}
}
