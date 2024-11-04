def solution(n, costs):
    answer = 0
    parents = [i for i in range(n)]
    costs.sort(key=lambda x: x[2])
    
    def find(x):
        if parents[x] == x:
            return x
        
        x = find(parents[x])
        return x
    
    def union(a, b):
        a = find(a)
        b = find(b)
        
        if a > b:
            parents[a] = b
        else:
            parents[b] = a
    
    for a, b, cost in costs:
        if find(a) == find(b):
            continue
        
        union(a, b)
        answer += cost
    
    return answer