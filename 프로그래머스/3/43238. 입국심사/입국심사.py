import math

def solution(n, times):
    start = 1
    end = 1000000000 * 1000000000
    while start <= end:
        mid = (start + end) // 2
        cnt = 0
        for time in times:
            cnt += mid // time
            
        if cnt < n:
            start = mid + 1
        else:
            end = mid - 1
    
    return start