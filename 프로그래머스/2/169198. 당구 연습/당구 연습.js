const solution = (m, n, startX, startY, balls) => {
    let answer = [];
    
    balls.map(([x, y]) => {
        answer.push(getNearList(m, n, startX, startY, x, y));
    });
    
    return answer;
}

const getNearList = (m, n, x1, y1, x2, y2) => {
    let symmetryPoints = [];
    
    if(x1 !== x2 || y1 < y2) {
        symmetryPoints.push([x1, -y1]);
    }
    
    if(x1 !== x2 || y1 > y2) {
        symmetryPoints.push([x1, n*2 - y1]);
    }
    
    if(y1 !== y2 || x1 < x2) {
        symmetryPoints.push([-x1, y1]);
    }
    
    if(y1 !== y2 || x1 > x2) {
        symmetryPoints.push([m*2 - x1, y1]);
    }
    
    return symmetryPoints.reduce((min, [x, y]) => {
        return Math.min(min, (x-x2)**2 + (y-y2)**2);
    }, n**2 + m**2);
}