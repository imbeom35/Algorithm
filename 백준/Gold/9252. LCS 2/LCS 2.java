import java.io.*;

public class Main {
    static char[] str1, str2;
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        N = str1.length;
        M = str2.length;

        int ans = getLCS();

        while(N != 0 && M != 0) {
            if(str1[N-1] == str2[M-1]) {
                sb.insert(0, str1[N-1]);
                N--;
                M--;
            } else if(dp[N][M] == dp[N-1][M]) {
                N--;
            } else if(dp[N][M] == dp[N][M-1]) {
                M--;
            }
        }

        System.out.println(ans);
        if(ans != 0) System.out.println(sb.toString());

        br.close();
    }

    static int getLCS() {
        dp = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[N][M];
    }
}
