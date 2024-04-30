import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[1] = 1;
        for(int i=2; i<10001; i++) {
            dp[i] = dp[i-1] + cal(i);
        }

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int cal(int x) {
        int cnt = 0;
        int three = 0;

        while(3 * three <= x) {
            if((x - 3 * three) % 2 == 0) cnt++;
            three++;
        }

        return cnt;
    }
}
