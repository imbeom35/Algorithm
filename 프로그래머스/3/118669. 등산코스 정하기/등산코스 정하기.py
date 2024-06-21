import heapq
from math import inf

def solution(n, paths, gates, summits):
    graph = [[] for _ in range(n + 1)]
    for i, j, w in paths:
        graph[i].append([j, w])
        graph[j].append([i, w])
    
    is_summit = [False] * (n + 1)
    for summit in summits:
        is_summit[summit] = True
        
    distance = [10000000] * (n + 1)
    queue = []
    for gate in gates:
        distance[gate] = 0
        heapq.heappush(queue, [0, gate])

    while queue:
        curr_d, curr_i = heapq.heappop(queue)
        
        if distance[curr_i] < curr_d or is_summit[curr_i]:
            continue
        for next_i, next_d in graph[curr_i]:
            next_d = max(distance[curr_i], next_d)
            if distance[next_i] > next_d:
                distance[next_i] = next_d
                heapq.heappush(queue, [next_d, next_i])

    result = [-1, inf]
    for summit in sorted(summits):
        if distance[summit] < result[1]:
            result[0] = summit
            result[1] = distance[summit]
            
    return result