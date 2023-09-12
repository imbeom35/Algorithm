import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][][] dp = new int[N+1][10][1<<10];
        int ans = 0;

        for(int j=1; j<10; j++) {
            dp[1][j][1<<j] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<(1<<10); k++) {
                    int bit = k | (1 << j);

                    if(j == 0) {
                        dp[i][j][bit] += dp[i-1][j+1][k]%MOD;
                    } else if(j == 9) {
                        dp[i][j][bit] += dp[i-1][j-1][k]%MOD;
                    } else {
                        dp[i][j][bit] += (dp[i-1][j+1][k]%MOD + dp[i-1][j-1][k]%MOD);
                    }

                    dp[i][j][bit] %= MOD;
                }
            }
        }

        for(int j=0; j<10; j++) {
            ans += dp[N][j][(1<<10)-1]%MOD;
            ans %= MOD;
        }

        System.out.println(ans);

        br.close();
    }
}
