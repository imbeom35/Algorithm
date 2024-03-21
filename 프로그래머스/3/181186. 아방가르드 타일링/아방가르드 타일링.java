class Solution {
    public final int MOD = 1000000007;
    
    public int solution(int n) {
        long[] dp = new long[100001];
        long[] unique = {0, 1, 2, 5, 2, 2, 4};
        long[] sum = {12, 2, 4};
        dp[1] = 1;
        for(int i=1; i<4; i++) {
            dp[i] = unique[i];
            for(int j=1; j<i; j++) dp[i] += unique[j] * dp[i-j];
        }

        if(n >= 4) {
            for(int i=4; i<=n; i++) {
                dp[i] += (sum[i%3] + dp[i-1] * unique[1] + dp[i-2] * unique[2] + dp[i-3] * unique[3]) % MOD;
                sum[i%3] += (dp[i-1] * unique[4] + dp[i-2] * unique[5] + dp[i-3] * unique[6]) % MOD;
            }
        }
        
        return Math.toIntExact(dp[n]);
    }
}