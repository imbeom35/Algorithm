def solution(n, t, m, timetable):
    answer = 0
    
    timetable = [int(time[:2])*60+int(time[3:]) for time in timetable]
    timetable.sort()
    
    busTime = [9*60+t*i for i in range(n)]
    
    i = 0 # 버스에 탈 크루의 인덱스
    for bt in busTime: # 도착 시간 순회
        cnt = 0 # 버스에 타는 크루 수
        while cnt < m and i < len(timetable) and timetable[i] <= bt:
            i += 1
            cnt += 1
        if cnt < m:
            answer = bt
        else:
            answer = timetable[i-1] - 1
            
    return str(answer//60).zfill(2) + ":" + str(answer%60).zfill(2)