def toDecimal(base, num):
    if len(num) == 1:
        return int(num)

    result = 0
    for i in range(len(num)):
        result += int(num[i]) * (base ** (len(num) - i - 1))

    return result

def toBase(base, num):
    if num == 0:
        return "0"
    
    result = ""
    while num > 0:
        result = str(num % base) + result
        num //= base

    return result

def solution(expressions):
    answer, answer_format = [], []
    max_format = 0
    hint = []
    
    for e in expressions:
        a, op, b, _, c = e.split(" ")
        
        for digit in a:
            max_format = max(max_format, int(digit))
        for digit in b:
            max_format = max(max_format, int(digit))
        
        if c != "X": 
            hint.append(e)
            for digit in c:
                max_format = max(max_format, int(digit))
        else:
            answer.append(e)
    
    for n in range(max_format + 1, 10):
        check = 1
        for h in hint:
            a, op, b, _, c = h.split(" ")
            a, b, c = toDecimal(n, a), toDecimal(n, b), toDecimal(n, c)
            if (op == '+') and (a + b != c): 
                check = 0
                break
            if (op == '-') and (a - b != c): 
                check = 0
                break
        
        if check: 
            answer_format.append(n)
    
    for i in range(len(answer)):
        a, op, b, _, c = answer[i].split(" ")
        ans_set = set()
        for base in answer_format:
            a_dec = toDecimal(base, a)
            b_dec = toDecimal(base, b)

            if op == "+":
                ans_set.add(str(toBase(base, a_dec + b_dec)))
            if op == "-":
                ans_set.add(str(toBase(base, a_dec - b_dec)))
        
        if len(ans_set) == 1:
            answer[i] = ' '.join([a, op, b, _, list(ans_set)[0]])
        else:
            answer[i] = ' '.join([a, op, b, _, "?"])
            
    return answer