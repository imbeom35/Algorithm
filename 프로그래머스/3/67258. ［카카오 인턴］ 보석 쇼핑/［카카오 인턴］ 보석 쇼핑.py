def solution(gems):
    dic = {}
    for gem in gems:
        if not dic.get(gem):
            dic[gem] = 0
    
    answer = []
    size = 100000
    count = 0
    start = 0
    for end in range(len(gems)):
        dic[gems[end]] += 1
        if dic[gems[end]] > 1:
            while dic[gems[start]] > 1:
                dic[gems[start]] -= 1
                start += 1
        else:
            count += 1
        if count == len(dic) and size > end - start:
            size = end - start
            answer = [start + 1, end + 1]
    
    return answer