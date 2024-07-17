def solution(user_id, banned_id):
    case = set()
    same = [[] for _ in range(len(banned_id))]
    
    for bi in range(len(banned_id)):
        for ui in range(len(user_id)):
            if isSame(banned_id[bi], user_id[ui]):
                same[bi].append(ui)
    
    dfs(0, 0, len(banned_id), same, case)
    
    return len(case)

def isSame(a, b):
    if len(a) != len(b):
        return False
    
    for i in range(len(a)):
        if a[i] == '*': continue
        if a[i] != b[i]:
            return False
        
    return True

def dfs(depth, visited, N, same, case):
    if depth == N:
        case.add(visited)
        return
    
    for i in same[depth]:
        if not (visited & 1 << i) :
            dfs(depth + 1, visited | 1 << i, N, same, case)