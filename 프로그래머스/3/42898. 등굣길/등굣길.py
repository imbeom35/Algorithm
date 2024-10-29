def solution(m, n, puddles):
    dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
    
    for x, y in puddles:
        dp[x][y] = -1
    dp[1][1] = 1
    
    for x in range(1, m+1):
        for y in range(1, n+1):
            if dp[x][y] == -1:
                continue
            
            if dp[x-1][y] > 0:
                dp[x][y] += dp[x-1][y]
                
            if dp[x][y-1] > 0:
                dp[x][y] += dp[x][y-1]
    
    return dp[m][n] % 1000000007