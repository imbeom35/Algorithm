import copy

def solution(key, lock):
    for _ in range(4):
        # key 회전
        transposed = list(zip(*key))
        key = [list(row)[::-1] for row in transposed]
        
        # lock 여백 생성
        padding_lock = add_padding(lock, len(key) - 1)
        
        # key, lock 결합
        for sx in range(len(padding_lock) - len(key) + 1):
            for sy in range(len(padding_lock) - len(key) + 1):
                copy_lock = copy.deepcopy(padding_lock)
                for x in range(len(key)):
                    for y in range(len(key)):
                        copy_lock[sy + y][sx + x] += key[y][x]
                        
                # 상태 확인
                if check(copy_lock, len(lock), len(key)):
                    return True
    
    return False

def add_padding(matrix, padding):
    size = len(matrix)
    new_size = size + 2 * padding
    new_matrix = [[0] * new_size for _ in range(new_size)]
    for i in range(size):
        for j in range(size):
            new_matrix[i + padding][j + padding] = matrix[i][j]
    
    return new_matrix

def check(lock, n, m):
    for x in range(n):
        for y in range(n):
            if lock[m - 1 + y][m - 1 + x] != 1: return False
        
    return True