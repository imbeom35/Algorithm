def solution(triangle):
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if j == 0:
                triangle[i][j] += triangle[i-1][0]
                continue
                
            if j == len(triangle[i])-1:
                triangle[i][j] += triangle[i-1][j-1]
                continue
            
            triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
    
    return max(triangle[-1])