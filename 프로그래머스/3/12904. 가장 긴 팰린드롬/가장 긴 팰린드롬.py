def solution(s):
    answer = 1
    dp = [[0]*len(s) for _ in range(len(s))]

    for i in range(len(dp)):
        dp[i][i] = 1
        
    for i in range(len(dp)-1):
        if s[i] == s[i+1]:
            dp[i][i+1] = 1
            answer = 2
    
    for k in range(3, len(dp)+1):
        for i in range(len(dp)-k+1):
            j = i + k - 1
            if dp[i+1][j-1] == 1 and s[i] == s[j]:
                dp[i][j] = 1
                answer = k

    return answer