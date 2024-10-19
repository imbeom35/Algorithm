def solution(a):
    
    """
    맨 왼쪽에 있는 값은 항상 남을 수 있다.
    맨 왼쪽을 제외한 풍선들만 연산을 진행하고,
    최종 두 풍선은 기회를 사용하거나 규칙대로 진행하는 수가 있기 때문이다.
    똑같이 맨 오른쪽도 같은 원리로 항상 남을 수 있다.
    이를 확장시켜서 중간의 i번째 값은
    이전(0 ~ i-1) 값들 중 최소 값과 이후(i+1 ~ max) 값들 중 최소 값에 대해 각각 비교했을 때
    둘 중 하나라도 i번째 값이 작다면 주어진 한 번의 기회로 최후까지 남을 수 있다.
    """
    
    answer = 0
    left_min = [0] * len(a)
    right_min = [0] * len(a)
    
    for i in range(len(a)):
        if i == 0:
            left_min[i] = a[0]
            right_min[len(a)-i-1] = a[len(a)-1]
            continue
            
        left_min[i] = min(left_min[i-1], a[i])
        right_min[len(a)-i-1] = min(right_min[len(a)-i], a[len(a)-i-1])
    
    for i in range(len(a)):
        if i == 0 or i == len(a)-1:
            answer += 1
            continue
        
        if left_min[i-1] > a[i] or right_min[i+1] > a[i]:
            answer += 1
        
    return answer