import java.io.*;

import static java.lang.Math.min;

public class Main {
    private static int[][] dp;
    private static int[][] enemy;
    private static int n,w;
    private static int INF = 123456789;
    static int top = 0, bottom = 1, both = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int caseNum = 0; caseNum < t; caseNum++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]) * 2;
            w = Integer.parseInt(input[1]);
            enemy = new int[2][n/2 + 1];

            //enemy 배열 초기화
            for (int i = 0; i < 2; i++) {
                String[] sections = br.readLine().split(" ");
                for (int j = 0; j < sections.length; j++) {
                    enemy[i][j+1] = Integer.parseInt(sections[j]);
                }
            }

            if(n == 2) {
                int ret = enemy[top][1]+enemy[bottom][1] <= w ? 1 : 2;
                System.out.println(ret);
                continue;
            }

            int ret = INF;

            //연결되지 않은 경우
            dp = new int[3][n/2 + 1];
            dp[top][1]=1; dp[bottom][1]=1;
            dp[both][1] = enemy[top][1]+enemy[bottom][1] <= w ? 1 : 2;
            solve();
            ret = min(ret, dp[both][n/2]);

            //위만 연결된 경우
            if(enemy[top][1]+enemy[top][n/2] <= w){
                dp = new int[3][n/2 + 1];
                dp[top][1]=1; dp[bottom][1]=INF;
                dp[both][1] = 2; dp[both][0] = INF;
                solve();
                ret = min(ret, dp[bottom][n/2]);
            }

            //아래만 연결된 경우
            if(enemy[bottom][1]+enemy[bottom][n/2] <= w) {
                dp = new int[3][n/2 + 1];
                dp[bottom][1]=1; dp[top][1]=INF;
                dp[both][1] = 2; dp[both][0] = INF;
                solve();
                ret = min(ret, dp[top][n/2]);
            }

            //둘 다 연결된 경우
            if(enemy[top][1]+enemy[top][n/2] <= w
                    && enemy[bottom][1]+enemy[bottom][n/2] <= w) {
                dp = new int[3][n/2 + 1];
                dp[top][1]=dp[bottom][1]=INF;
                dp[both][1]=2; dp[both][0] = INF;
                solve();
                ret = min(ret, dp[both][n/2-1]);
            }

            System.out.println(ret);
        }
    }

    public static void solve(){
        for (int i = 2; i <= n/2; i++) {
            //top
            dp[top][i] = dp[both][i-1]+1;
            if(enemy[top][i-1] + enemy[top][i] <= w) dp[top][i] = min(dp[bottom][i-1]+1, dp[top][i]);

            //bottom
            dp[bottom][i] = dp[both][i-1]+1;
            if(enemy[bottom][i-1] + enemy[bottom][i] <= w) dp[bottom][i] = min(dp[top][i-1]+1, dp[bottom][i]);

            //both
            dp[both][i] = min(dp[top][i]+1, dp[bottom][i]+1);
            if(enemy[top][i]+enemy[bottom][i] <= w) dp[both][i] = min(dp[both][i-1]+1, dp[both][i]);
            if(enemy[top][i-1]+enemy[top][i] <= w && enemy[bottom][i-1]+enemy[bottom][i] <= w)
                dp[both][i] = min(dp[both][i-2]+2 ,dp[both][i]);
        }
    }
}
