import heapq
 
def solution(jobs):
    answer = 0
    now_time = 0
    finish = 0
    heap = []
    total_time = 0
    before_request = -1
    
    while finish < len(jobs):
        for job in jobs:
            if before_request < job[0] <= now_time:
                heapq.heappush(heap, [job[1],job[0]])
                
        if len(heap)>0:
            now_working = heapq.heappop(heap)
            before_request = now_time
            now_time += now_working[0]
            total_time += (now_time - now_working[1])
            finish += 1
        else:
            now_time += 1
    answer = int(total_time / len(jobs))
    return answer