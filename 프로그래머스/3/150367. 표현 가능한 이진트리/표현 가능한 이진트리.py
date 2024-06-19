import math

def check(num_bin, prev_parent):
    # 리프노드일 경우 종료
    if not num_bin: return True
    
    # 중앙값으로 자식노드 찾기
    mid = len(num_bin) // 2
    son = (num_bin[mid] == '1')

    # 자식이 존재하면 부모가 존재해야 함
    if son and not prev_parent: return False
    
    return check(num_bin[mid + 1:], son) and check(num_bin[:mid], son)

def solution(numbers):
    answer = []
    
    for num in numbers:
        # 2진수 변환
        num_bin = bin(num)[2:]
        digit = 2 ** (int(math.log(len(num_bin), 2)) + 1) - 1
        # 포화 이진트리를 만족하도록 더미 노드 추가
        num_bin = "0" * (digit - len(num_bin)) + num_bin
        
        if num_bin[len(num_bin) // 2] == '1' and check(num_bin, True):
            answer.append(1)
        else:
            answer.append(0)
    
    return answer