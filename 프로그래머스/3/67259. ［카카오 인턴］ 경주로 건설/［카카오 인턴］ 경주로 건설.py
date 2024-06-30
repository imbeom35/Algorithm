import math
from heapq import heappop, heappush

def solution(board):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    N = len(board)
    visited = [[[math.inf for _ in range(4)] for _ in range(N)] for _ in range(N)]
    visited[0][0] = [0, 0, 0, 0]
    
    heap = [[0, 0, 0, 1], [0, 0, 0, 3]]
    while heap:
        cost, y, x, direct = heappop(heap)
        if x == N-1 and y == N-1: continue
        
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if nx >= N or nx < 0 or ny >= N or ny < 0 or board[ny][nx] == 1: continue
            newCost = cost + (600 if direct != d else 100)
            if visited[ny][nx][d] > newCost:
                visited[ny][nx][d] = newCost
                heappush(heap, [newCost, ny, nx, d])
    
    result = visited[N-1][N-1]
    answer = min(result[0], result[1], result[2], result[3])
    return answer
        
        