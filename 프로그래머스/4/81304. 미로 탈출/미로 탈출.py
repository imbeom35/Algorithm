from heapq import heappush, heappop
from collections import defaultdict
from math import inf

def solution(n, start, end, roads, traps):
    A = defaultdict(list)
    for u, v, w in roads:
        A[u].append( (v, w, False) )
        A[v].append( (u, w, True) )
    
    flipped = [False] * (n+1)
    q = [(0, start, flipped)]
    
    start_state = ( start, False, tuple([False] * len(A[start])) )
    dist = {}
    dist[start_state] = 0
    while q:
        d, u, flipped = heappop(q)
        
        u_state = ( u, flipped[u], tuple(flipped[v] for v, _, _ in A[u]) )
        if d > dist.get(u_state, inf):
            continue
        
        for v, w, valid_when_flipped in A[u]:
            edge_flipped = flipped[u] ^ flipped[v]
            
            if (valid_when_flipped is False and not edge_flipped) or \
            	(valid_when_flipped is True and edge_flipped):
                    
                f = flipped[:]
                if v in traps:
                    f[v] = not f[v]
                
                v_state = ( v, f[v], tuple(flipped[x] for x, _, _ in A[v]) )
                
                if d + w < dist.get(v_state, inf):
                    dist[v_state] = d + w
                    heappush( q, (d+w, v, f) )
            
    candidates = [dist[k] for k in dist if k[0] == end]
    return min(candidates)