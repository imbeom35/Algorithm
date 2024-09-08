from itertools import product
from copy import deepcopy

def rotate(clockHands, r, c, cnt):
    dRow, dCol = [0, 0, 0, 1, -1], [0, 1, -1, 0, 0]
    for d in range(5):
        nr, nc = r + dRow[d], c + dCol[d]
        if 0 <= nr < len(clockHands) and 0 <= nc < len(clockHands):
            clockHands[nr][nc] = (clockHands[nr][nc] + cnt) % 4

def solution(clockHands):
    answer = float('inf')
    n = len(clockHands)
    
    for case in product(range(4), repeat=n):
        copy_clock = deepcopy(clockHands)
    
        for i in range(n):
            rotate(copy_clock, 0, i, case[i])
        
        result = sum(case)
        
        for r in range(1, n):
            for c in range(n):
                if copy_clock[r-1][c]:
                    cnt = 4 - copy_clock[r-1][c]
                    rotate(copy_clock, r, c, cnt)
                    result += cnt

        if sum(copy_clock[n-1]):
            continue
        
        answer = min(answer, result)
                    
    return answer