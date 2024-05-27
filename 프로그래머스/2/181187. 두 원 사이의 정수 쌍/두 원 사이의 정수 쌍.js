const solution = (r1, r2) => {
    let answer = 0;
    
    for(let i=1; i<=r2; i++) {
        let maxY = Math.floor(Math.sqrt(r2**2 - i**2));
        let minY = 0;
        if(r1 > i) {
            minY = Math.ceil(Math.sqrt(r1**2 - i**2));
        }
        answer += (maxY - minY + 1);
    }
    
    return answer*4;
}