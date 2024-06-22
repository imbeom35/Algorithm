def solution(sales, links):
    sales = [0] + sales
    tree = [[] for _ in range(len(sales) + 1)]
    for a, b in links:
        tree[a].append(b)
    dp = [[0, 0] for _ in range(len(sales) + 1)]
    dfs(1, dp, tree, sales)
    
    return min(dp[1])

def dfs(node, dp, tree, sales):
    # 리프노드일 경우, 해당 노드의 비용만 계산
    if not tree[node]:
        dp[node][0] = sales[node]
        dp[node][1] = 0
        return
    
    dp[node][0] = sales[node]
    min_gap = float('inf')
    
    for i in tree[node]:
        dfs(i, dp, tree, sales)
        # 부모노드가 참석할 때 비용은 모든 자식노드의 최소 비용의 합
        dp[node][0] += min(dp[i])
        min_gap = min(min_gap, dp[i][0] - dp[i][1])
        if min_gap < 0: min_gap = 0

    # 부모노드가 참석하지 않을 때 비용은
    # 참석할 때 비용에서 부모노드의 비용을 빼고
    # 추가로 모든 자식노드 중에서 하나를 참석할 때 비용이 가장 적은 값으로 치환한 값
    dp[node][1] = dp[node][0] + min_gap - sales[node]