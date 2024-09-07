def solution(beginning, target):
    cnt_n = 0
    cnt_m = 0
    
    n = len(beginning)
    m = len(beginning[0])
    
    for i in range(n):
        if beginning[i][0] == target[i][0]: continue
        for j in range(m):
            beginning[i][j] = 1 - beginning[i][j]
        cnt_n += 1
        
    for i in range(m):
        if beginning[0][i] == target[0][i]: continue
        for j in range(n):
            beginning[j][i] = 1 - beginning[j][i]
        cnt_m += 1
    
    for i in range(n):
        for j in range(m):
            if beginning[i][j] != target[i][j]:
                return -1
    
    return min(cnt_n + cnt_m, n - cnt_n + m - cnt_m)