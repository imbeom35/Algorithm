def solution(n, results):
    answer = 0
    win = [set() for _ in range(n+1)] # win[x] x선수에게 이긴 선수들의 집합
    los = [set() for _ in range(n+1)] # los[x] x선수에게 진 선수들의 집합
    
    for winner, loser in results:
        win[loser].add(winner)
        los[winner].add(loser)
    
    for i in range(1, n+1):
        # i에게 이긴 선수는 i에게 진 선수들에게 이긴다(i)
        for winner in win[i]:
            los[winner].update(los[i])
        # i에게 진 선수는 i에게 이긴 선수들에게 진다
        for loser in los[i]:
            win[loser].update(win[i])
                
    for i in range(1, n+1):
        # 자신보다 잘하는 선수의 수와 못하는 선수의 수의 합이 자신을 제외한 모든 선수의 숫자와 같다면 순위를 매길 수 있다
        if len(win[i]) + len(los[i]) == n-1:
            answer += 1
    
    return answer