def solution(enroll, referral, seller, amount):
    answer = [0] * len(enroll)
    name_to_idx = {}
    
    for i in range(len(enroll)):
        name = enroll[i]
        name_to_idx[name] = i
    
    def dfs(cur_name, price):
        # 수수료를 제외한 금액 얻기
        charge = price // 10
        cur_idx = name_to_idx[cur_name]
        answer[cur_idx] += price - charge
        
        # 수수료와 추천인이 존재하는 경우 수수료 전달
        nxt_name = referral[cur_idx]
        if not nxt_name == '-' and charge > 0:
            dfs(nxt_name, charge)
    
    for i in range(len(seller)):
        dfs(seller[i], amount[i] * 100)
            
    return answer