def solution(routes):
    answer = 0
    end = -30001
    
    routes.sort(key=lambda x: x[0])
    
    for s, e in routes:
        if end < s:
            answer += 1
            end = e
            continue
        
        if end > e:
            end = e
    
    return answer