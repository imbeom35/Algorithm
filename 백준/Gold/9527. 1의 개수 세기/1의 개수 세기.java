import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[] dp = new long[55]; //dp[i]: 2진 자릿수가 i+1개일 때의 1의 개수의 누적합
        dp[0] = 1;
        for(int i=1; i<55; i++) {
            //dp[i] = dp[i-1]*2 + 2*i
            //dp[i-1]을 i+1번째 자리가 0일때와 1일때를 계산하여 2배로 가지며
            //2^i만큼 i+1번째 자리를 반복한다.
            dp[i] = (dp[i-1] << 1) + (1L << i);
        }

        long result = calOne(dp, B) - calOne(dp, A-1);
        System.out.println(result);
        br.close();
    }

    public static long calOne(long[] dp, long N) {
        long count = N & 1;
        //N보다 작은 2^n의 n의 최대값
        int size = (int) (Math.log(N)/Math.log(2));

        for(int i=size; i>0; i--) {
            if((N & (1L << i)) != 0L) {
                //dp[i-1]: 자릿수가 i개일 때의 1의 개수의 누적합
                //(N - (1L << i) + 1): N의 i 자리 이하의 값 + 1만큼 i 자리의 1을 반복한다.
                count += dp[i-1] + (N - (1L << i) + 1);
                N -= (1L << i);
            }
        }
        return count;
    }
}
