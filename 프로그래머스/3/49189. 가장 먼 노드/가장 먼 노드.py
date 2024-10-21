import heapq

def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n+1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    dist = [50000] * (n+1)
    heap = []
    heapq.heappush(heap, (0, 1))
    dist[1] = 0
    
    while heap:
        d, cur_node = heapq.heappop(heap)
        
        for nxt_node in graph[cur_node]:
            if dist[nxt_node] > dist[cur_node] + 1:
                dist[nxt_node] = dist[cur_node] + 1
                heapq.heappush(heap, (dist[nxt_node], nxt_node))
    
    dist[0] = 0
    max_value = max(dist)
    for d in dist:
        if d == max_value:
            answer += 1
    
    return answer