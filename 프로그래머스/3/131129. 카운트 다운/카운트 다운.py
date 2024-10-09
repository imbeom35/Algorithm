def solution(target):
    P = {}
    for i in range(1, 21):
        P[2 * i] = 0
        P[3 * i] = 0
        P[i] = 1
    P[50] = 1
    
    min_darts = [100001] * 100001
    max_sbs = [0] * 100001
    
    # 다트 하나를 던져서 나오는 점수에 대한 최소 싱글 불 개수를 구한다
    for i, sb in P.items():
        min_darts[i] = 1
        max_sbs[i] = sb
    
    # 다트를 여러번 던져서 나오는 점수에 대한 최소 싱글 불 개수를 구한다
    for t in range(1, target + 1):
        # 한번 던져서 구한 경우는 패스
        if min_darts[t] != 100001:
            continue
        
        # 다트의 횟수와 싱글 불의 개수는 각각 최소와 최대를 구해야 하므로, 반대의 경우로 초기화
        t_darts, t_sbs = 100001, 0
        
        # t 이전에 얻은 점수에서 최적해를 구한다
        for score, sbs in P.items():
            if t - score < 0:
                continue
            
            # t 이전의 s에서 한번의 다트를 던졌을 때
            s = t - score
            # 다트의 수가 최소가 되거나, 다트의 수가 같으면서 싱글 불의 개수가 최대가 되는 경우 해당 값을 저장
            if (min_darts[s] + 1 < t_darts) or (min_darts[s] + 1 == t_darts and max_sbs[s] + sbs > t_sbs):
                t_darts = min_darts[s] + 1
                t_sbs = max_sbs[s] + sbs
        
        min_darts[t] = t_darts
        max_sbs[t] = t_sbs

    return [min_darts[target], max_sbs[target]]