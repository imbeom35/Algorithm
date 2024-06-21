import sys
sys.setrecursionlimit(10**7)

def solution(n, m, x, y, r, c, k):
    dy = [0, -1, 1, 0]
    dx = [1, 0, 0, -1]
    dm = ['d', 'l', 'r', 'u']
    visited = [[[False for i3 in range(k+1)] for i2 in range(m+1)] for i in range(n+1)]
    
    def dfs(curr_x, curr_y, depth, route):
        if depth == k:
            if curr_x == r and curr_y == c: return ''.join(route)
            else: return None
        
        for i in range(4):
            next_x = curr_x + dx[i]
            next_y = curr_y + dy[i]
            
            if next_x < 1 or next_x > n or next_y < 1 or next_y > m: continue
            if visited[next_x][next_y][depth] == True: continue
            visited[next_x][next_y][depth] = True
            
            route.append(dm[i])
            result = dfs(next_x, next_y, depth+1, route)
            if result is not None: return result
            route.pop()
            
    answer = dfs(x, y, 0, [])
    
    return answer if answer is not None else "impossible"