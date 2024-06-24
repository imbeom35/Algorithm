dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
n, m = 0, 0
visited = [[0]*5 for _ in range(5)]

def OOB(x, y):
    return x < 0 or x >= n or y < 0 or y >= m

def dfs(board, currx, curry, opx, opy):
    global visited
    if visited[currx][curry]: return 0
    ret = 0
    
    for dir in range(4):
        nx = currx + dx[dir]
        ny = curry + dy[dir]
        if OOB(nx, ny) or visited[nx][ny] or board[nx][ny] == 0: continue
        
        visited[currx][curry] = 1
        val = dfs(board, opx, opy, nx, ny) + 1
        visited[currx][curry] = 0
        
        # 1. 현재 저장된 턴은 패배인데 새로 계산된 턴은 승리인 경우
        # 즉시 갱신
        if ret % 2 == 0 and val % 2 == 1: ret = val
        # 2. 현재 저장된 턴과 새로 계산된 턴이 모두 패배인 경우
        # 최대한 늦게 지는 것을 선택
        elif ret % 2 == 0 and val % 2 == 0: ret = max(ret, val)
        # 최대한 빨리 이기는 것을 선택
        # 3. 현재 저장된 턴과 새로 계산된 턴이 모두 승리인 경우
        elif ret % 2 == 1 and val % 2 == 1: ret = min(ret, val)
        
    return ret

def solution(board, aloc, bloc):
    global n, m
    n = len(board)
    m = len(board[0])
    return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1])
        