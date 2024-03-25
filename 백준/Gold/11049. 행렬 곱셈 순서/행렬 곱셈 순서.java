import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int [N][N]; //dp[i][j]: i부터 j까지 행렬 곱 연산 개수의 최소값
        for(int k=1; k<N; k++) { //k개의 행렬 선택
            for(int i=0; i+k<N; i++) { //i번째 부터 연산
                dp[i][i+k] = Integer.MAX_VALUE;
                for(int j=i; j<i+k; j++) {
                    //이전에 k-1개의 최소값을 구했기 때문에
                    //dp[i][j]와 dp[j+1][i+k]의 곱 연산 개수의 최소값을 정답으로 갖는다
                    dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j] + dp[j+1][i+k] + matrix[i][0]*matrix[j][1]*matrix[i+k][1]);
                }
            }
        }

        System.out.println(dp[0][N-1]);

        br.close();
    }
}
