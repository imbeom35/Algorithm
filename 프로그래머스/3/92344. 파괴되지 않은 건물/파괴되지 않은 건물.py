def solution(board, skill):
    answer = 0
    acc = [[0 for _ in range(len(board[0]) + 1)] for _ in range(len(board) + 1)]
    
    for type, r1, c1, r2, c2, degree in skill:
        acc[r1][c1] += degree if type == 2 else -degree
        acc[r1][c2 + 1] += -degree if type == 2 else degree
        acc[r2 + 1][c1] += -degree if type == 2 else degree
        acc[r2 + 1][c2 + 1] += degree if type == 2 else -degree
    
    for r in range(len(acc) - 1):
        for c in range(len(acc[0]) - 1):
            acc[r][c + 1] += acc[r][c]
            
    for c in range(len(acc[0]) - 1):
        for r in range(len(acc) - 1):
            acc[r + 1][c] += acc[r][c] 
            
    for r in range(len(board)):
        for c in range(len(board[0])):
            board[r][c] += acc[r][c]
            if board[r][c] > 0: answer += 1
            
    return answer