def solution(bandage, health, attacks):
    answer = 0
    
    cast, second, final = bandage
    curhealth = health
    lastAttackTime = 0
    for currAttackTime, damage in attacks:
        diff = currAttackTime - lastAttackTime - 1
        curhealth += (diff // cast) * final
        curhealth += diff * second
        if curhealth > health: curhealth = health
        
        curhealth -= damage
        if curhealth <= 0:
            return -1
        lastAttackTime = currAttackTime
    
    return curhealth