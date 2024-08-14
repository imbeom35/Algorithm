def solution(lines):
    answer = 0
    newLines = []
    
    for line in lines:
        date, time, s = line.split(' ')
        hour, minutes, seconds = time.split(':')
        end = int(hour) * 3600 + int(minutes) * 60 + float(seconds)
        start = end - float(s.rstrip('s')) + 0.001
        newLines.append([start, end])
    
    newLines.sort(key=lambda x: x[0])
    
    for curr_i in range(len(newLines)):
        cnt = 1
        scope_standard = newLines[curr_i][0] - 1
        
        for i in range(0, curr_i):
            start, end = newLines[i]
            if scope_standard < end:
                cnt += 1
        
        answer = max(answer, cnt)
                
    return answer