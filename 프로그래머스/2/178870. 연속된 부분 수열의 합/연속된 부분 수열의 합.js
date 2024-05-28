const solution = (sequence, k) => {
    let answer = [];
    let sum = 0;
    let start = 0;
    let end = 0;
    let min = 10000000000;
    
    while(true) {
        if(end >= sequence.length) break;
        sum += sequence[end++];
        while(sum > k) {
            sum -= sequence[start++];
        }
        if(sum == k && min > end - start) {
            min = end - start;
            answer = [start, end-1];
        }
    }
    
    return answer;
}