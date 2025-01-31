import heapq

def solution(n, works):
    answer = 0
    
    max_heap = [-x for x in works]
    heapq.heapify(max_heap)
    
    for _ in range(n):
        v = heapq.heappop(max_heap)
        if v == 0:
            break
        
        v += 1
        heapq.heappush(max_heap, v)
        
    for x in max_heap:
        answer += x**2
    
    return answer