def solution(n, computers):
    answer = 0
    root = [i for i in range(n)]
    
    def find(x):
        if root[x] == x:
            return x
        x = find(root[x])
        return x
    
    def union(a, b):
        a = find(a)
        b = find(b)
        
        if a == b:
            return
            
        if a > b:
            root[a] = b
        else:
            root[b] = a
    
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if computers[i][j] == 1:
                union(i, j)
    
    for i in range(n):
        if root[i] == i:
            answer += 1
    
    return answer