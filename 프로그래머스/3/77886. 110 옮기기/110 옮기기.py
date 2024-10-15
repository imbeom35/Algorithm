def solution(s):
    answer = []
    
    for arr in s:
        stack = []
        cnt = 0
        
        for i in range(len(arr)):
            stack.append(arr[i])
            n = len(stack)
            if len(stack) > 2 and stack[n-3:n] == ['1', '1', '0']:
                cnt += 1
                del stack[n-3:n]
                
        stack = ''.join(stack[::-1])
        idx = stack.find('0')
        
        if idx != -1:
            res = stack[:idx] + '011' * cnt + stack[idx:]
        else:
            res = stack + '011' * cnt
        
        answer.append(''.join(res[::-1]))
    
    return answer