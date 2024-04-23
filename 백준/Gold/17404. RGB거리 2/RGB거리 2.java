import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = INF;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i == j) dp[0][j] = arr[0][j];
                else dp[0][j] = INF;
            }

            for(int j=1; j<N; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + arr[j][2];
            }

            for(int j=0; j<3; j++) {
                if(i != j) ans = Math.min(ans, dp[N-1][j]);
            }
        }

        System.out.println(ans);

        br.close();
    }
}
