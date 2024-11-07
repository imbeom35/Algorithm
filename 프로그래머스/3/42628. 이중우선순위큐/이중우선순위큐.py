import heapq

def solution(operations):
    answer = []
    heap = []
    
    for op in operations:
        o, v = op.split()
        v = int(v)
        
        if o == 'I':
            heapq.heappush(heap, v)
        if o == 'D':
            if not heap:
                continue
            if v == -1:
                heapq.heappop(heap)
            else:
                heap.sort()
                heap.pop()
    
    heap.sort()
    if heap:
        answer = [heap[-1], heap[0]]
    else:
        answer = [0, 0]
    
    return answer