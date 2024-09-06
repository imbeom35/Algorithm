import heapq
import math

def solution(n, roads, sources, destination):
    graph = [[] for _ in range(n+1)]
    
    for a, b in roads:
        graph[a].append(b)
        graph[b].append(a)
        
    dist = dijkstra(n, destination, graph)
    answer = []
    for s in sources:
        answer.append(dist[s])
    
    return answer

def dijkstra(n, d, graph):
    visited = [False] * (n+1)
    dist = [math.inf] * (n+1)
    dist[d] = 0
    
    heap = []
    heapq.heappush(heap, (0, d))
    
    while heap:
        cur_dist, cur = heapq.heappop(heap)
        
        if visited[cur]: continue
        visited[cur] = True
        
        for nxt in graph[cur]:
            if dist[nxt] > cur_dist + 1:
                dist[nxt] = cur_dist + 1
                heapq.heappush(heap, (dist[nxt], nxt))
    
    for i in range(len(dist)):
        if dist[i] == math.inf:
            dist[i] = -1
    
    return dist