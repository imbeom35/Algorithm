def solution(alp, cop, problems):
    max_alp_req, max_cop_req = [0, 0]
    
    for problem in problems:
        max_alp_req = max(max_alp_req, problem[0])
        max_cop_req = max(max_cop_req, problem[1])
        
    alp = min(alp, max_alp_req)
    cop = min(cop, max_cop_req)
        
    dp = [[float('inf') for _ in range(max_cop_req + 1)] for _ in range(max_alp_req + 1)]
    dp[alp][cop] = 0
    
    for a in range(alp, max_alp_req + 1):
        for c in range(cop, max_cop_req + 1):
            if a < max_alp_req:
                dp[a+1][c] = min(dp[a+1][c], dp[a][c] + 1)
            if c < max_cop_req:
                dp[a][c+1] = min(dp[a][c+1], dp[a][c] + 1)
                
            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if a >= alp_req and c >= cop_req:
                    new_alp = min(a + alp_rwd, max_alp_req)
                    new_cop = min(c + cop_rwd, max_cop_req)
                    dp[new_alp][new_cop] = min(dp[new_alp][new_cop], dp[a][c] + cost)
    
    return dp[max_alp_req][max_cop_req]