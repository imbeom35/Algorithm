import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][N+1]; //dp[j][i]: j번째 위치에서 j+i-1번째 위치까지의 수열이 팰린드롬인 경우 1 아닌경우 0을 가진다.
        for(int i=1; i<=N; i++) { //고르는 개수
            for(int j=1; j<=N; j++) { //시작위치
                if(j+i-1 > N) continue;
                if(i == 1) {
                    dp[j][i] = 1;
                    continue;
                }
                if(i == 2) {
                    if(number[j] == number[j+1]) dp[j][i] = 1;
                    else dp[j][i] = 0;
                    continue;
                }
                if(number[j] == number[j+i-1] && dp[j+1][i-2] == 1) {
                    dp[j][i] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E-S+1]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
