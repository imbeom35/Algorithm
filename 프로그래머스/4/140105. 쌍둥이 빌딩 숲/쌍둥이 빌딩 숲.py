import sys
sys.setrecursionlimit(10**6)
memo = {(1, 1): 1}

def solution(n, count):
    return dfs(n, count)

def dfs(h, s):
    if h == 0 or s == 0:
        return 0
    
    if (h, s) in memo:
        return memo[(h, s)]
    
    v = dfs(h-1, s-1) + dfs(h-1, s) * 2 * (h-1)
    memo[(h, s)] = v % 1000000007
    
    return memo[(h, s)]