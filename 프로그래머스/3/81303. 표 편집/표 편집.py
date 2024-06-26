def solution(n, k, cmds):
    linked_list = {i: [i - 1, i + 1] for i in range(n)}
    table = ['O' for _ in range(n)]
    delete = []
    
    for cmd in cmds:
        cmd = cmd.split()
        
        if cmd[0] == 'U':
            for _ in range(int(cmd[1])):
                k = linked_list[k][0]
                
        elif cmd[0] == 'D':
            for _ in range(int(cmd[1])):
                k = linked_list[k][1]
                
        elif cmd[0] == 'C':
            table[k] = 'X'
            prev, nxt = linked_list[k]
            delete.append((prev, k, nxt))
            
            if nxt == n:
                k = linked_list[k][0]
            else:
                k = linked_list[k][1]
                
            if prev == -1:
                linked_list[nxt][0] = prev
            elif nxt == n:
                linked_list[prev][1] = nxt
            else:
                linked_list[prev][1] = nxt
                linked_list[nxt][0] = prev
                
        else:
            prev, now, nxt = delete.pop()
            table[now] = 'O'
            
            if prev == -1:
                linked_list[nxt][0] = now
            elif nxt == n:
                linked_list[prev][1] = now
            else:
                linked_list[prev][1] = now
                linked_list[nxt][0] = now
            
    return ''.join([x for x in table])