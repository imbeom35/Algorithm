def solution(begin, target, words):
    answer = 0
    size = len(target)
    visited = {}
    for word in words:
        visited[word] = 100
    queue = []
    queue.append((begin, 0))
    
    while queue:
        cur, cnt = queue.pop()
        
        if cur == target:
            answer = cnt
            break
        
        for nxt in words:
            dif = 0
            for i in range(size):
                if cur[i] != nxt[i]:
                    dif += 1
            
            if dif == 1 and visited[nxt] > cnt:
                visited[nxt] = cnt
                queue.append((nxt, cnt+1))
    
    return answer