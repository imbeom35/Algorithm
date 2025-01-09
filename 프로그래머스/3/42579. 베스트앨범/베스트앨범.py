def solution(genres, plays):
    answer = []
    music_dict = {}
    
    for i in range(len(genres)):
        if genres[i] not in music_dict:
            music_dict[genres[i]] = [0, []]
        
        music_dict[genres[i]][0] += plays[i]
        music_dict[genres[i]][1].append([i, plays[i]])
    
    genres_list = list(music_dict.values())
    genres_list.sort(key=lambda x: -x[0])
    
    print(genres_list)
    for _, plays_list in genres_list:
        plays_list.sort(key=lambda x: -x[1])
        cnt = 0
        for idx, _ in plays_list:
            cnt += 1
            answer.append(idx)
            if cnt >= 2:
                break
    
    return answer