from collections import deque

def solution(rc, operations):
    N = len(rc)
    M = len(rc[0])
    left_col = deque([rc[i][0] for i in range(N)])
    right_col = deque([rc[i][M - 1] for i in range(N)])
    rows = deque([deque(rc[i][1:M - 1]) for i in range(N)])
    
    for op in operations:
        if op == 'ShiftRow':
            left_col.appendleft(left_col.pop())
            rows.appendleft(rows.pop())
            right_col.appendleft(right_col.pop())
        else:
            rows[0].appendleft(left_col.popleft())
            right_col.appendleft(rows[0].pop())
            rows[N - 1].append(right_col.pop())
            left_col.append(rows[N - 1].popleft())
    
    answer = []
    for i in range(N):
        answer.append([left_col[i]] + list(rows[i]) + [right_col[i]])
    
    return answer