import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;

        int[] memoryArr = new int[N];
        int[] costArr = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            memoryArr[i] = Integer.parseInt(st1.nextToken());
            costArr[i] = Integer.parseInt(st2.nextToken());
        }

        // dp[i][j]는 i번째 앱을 포함했을 때, j의 비용을 지불하여 얻을 수 있는 최대 메모리
        int[][] dp = new int[N][10001];
        for(int i=0; i<N; i++) {
            int cost = costArr[i];
            int memory = memoryArr[i];

            for(int j=0; j<=10000; j++) {
                if(i==0) {
                    if(j >= cost) dp[i][j] = memory;
                } else {
                    if(j >= cost) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost] + memory);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }

                if(dp[i][j] >= M) answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);
        br.close();
    }
}
