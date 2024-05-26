const solution = (targets) => {
    let answer = 0;
    
    targets.sort((a, b) => {
        return a[1] - b[1];
    });
    
    let end = 0;
    targets.forEach((target) => {
        if(target[0] >= end) {
            end = target[1];
            answer++;
        }
    });
    
    return answer;
}