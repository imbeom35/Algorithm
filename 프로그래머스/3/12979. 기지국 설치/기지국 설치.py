import math

def solution(n, stations, w):
    answer = 0
    blanks = []
    start = 1
    
    for s in stations:
        end = s - w
        if start < end:
            blanks.append(end - start)
        start = end + w*2 + 1
        
    if start <= n:
        blanks.append(n - start + 1)

    for b in blanks:
        answer += math.ceil(b/(w*2+1))

    return answer