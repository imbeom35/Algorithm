def solution(a, edges):
    if sum(a) != 0:
        return -1
    
    answer = 0
    size = len(a)
    edge_cnt = [0] * size
    visited = [False] * size
    graph = {}
    
    for i in range(size):
        graph[i] = []
    
    for p, c in edges:
        edge_cnt[p] += 1
        edge_cnt[c] += 1
        graph[p].append(c)
        graph[c].append(p)
        
    queue = []
    for i in range(size):
        if edge_cnt[i] == 1:
            queue.append(i)
    
    while queue:
        cur = queue.pop()
        visited[cur] = True
        
        if a[cur] == 0:
            continue
            
        answer += abs(a[cur])
        
        for nxt in graph[cur]:
            if not visited[nxt]:
                a[nxt] += a[cur]
                edge_cnt[nxt] -= 1
                
                if edge_cnt[nxt] == 1:
                    queue.append(nxt)
    
    return answer