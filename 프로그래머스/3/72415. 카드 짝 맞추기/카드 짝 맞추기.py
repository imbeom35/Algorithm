from collections import deque
from math import inf
from copy import deepcopy

answer = inf

def move(board, cy, cx, ty, tx):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    queue = deque()
    queue.append((cy, cx))
    visited = [[inf for _ in range(4)] for _ in range(4)]
    visited[cy][cx] = 0
    while queue:
        y, x = queue.popleft()
        if y == ty and x == tx:
            return visited[y][x]

        for i in range(4):
            # arrow_key
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < 4 and 0 <= nx < 4 and visited[ny][nx] > visited[y][x] + 1:
                visited[ny][nx] = visited[y][x] + 1
                queue.append((ny, nx))
                
            # ctrl + arrow_key
            while 0 <= ny + dy[i] < 4 and 0 <= nx + dx[i] < 4 and board[ny][nx] == 0:
                ny, nx = ny + dy[i], nx + dx[i]
            if 0 <= ny < 4 and 0 <= nx < 4 and visited[ny][nx] > visited[y][x] + 1:
                visited[ny][nx] = visited[y][x] + 1
                queue.append((ny, nx))

def dfs(board, card_list, y, x, visited, cnt):
    global answer
    if len(visited) == len(card_list):
        answer = min(answer, cnt)
        return
    
    for key in card_list.keys():
        if key in visited: continue
            
        for i in range(2):
            board_copy = deepcopy(board)
            if i == 0:
                ty1, tx1 = card_list[key][0]
                ty2, tx2 = card_list[key][1]
            else:
                ty1, tx1 = card_list[key][1]
                ty2, tx2 = card_list[key][0]
                
            # 첫 번째 카드
            add = move(board_copy, y, x, ty1, tx1)
            board_copy[ty1][tx1] = 0

            # 두 번째 
            add += move(board_copy, ty1, tx1, ty2, tx2)
            board_copy[ty2][tx2] = 0
            visited.append(key)
            dfs(board_copy, card_list, ty2, tx2, visited, cnt + add + 2)
            visited.pop()

def solution(board, r, c):
    global answer
    
    card_list = {}
    for y in range(4):
        for x in range(4):
            if board[y][x] == 0: continue
            if board[y][x] not in card_list:
                card_list[board[y][x]] = [[y, x]]
            else:
                card_list[board[y][x]].append([y, x])
    
    dfs(board, card_list, r, c, [], 0)
    
    return answer