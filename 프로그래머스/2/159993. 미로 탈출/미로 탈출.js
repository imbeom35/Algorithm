const solution = (maps) => {
    let start, lever, exit;
    
    maps.forEach((map, i) => {
        for(let j=0; j<map.length; j++) {
            if(map.charAt(j) === 'S') start = {x: j, y:i};
            if(map.charAt(j) === 'L') lever = {x: j, y:i};
            if(map.charAt(j) === 'E') exit = {x: j, y:i};
        }
    });
    
    let val1 = bfs(maps, start, lever);
    let val2 = bfs(maps, lever, exit);
    if(val1 === -1 || val2 === -1) return -1;
    
    return val1 + val2;
}

const bfs = (maps, start, end) => {
    const Y = maps.length;
    const X = maps[0].length;
    const dx = [1, -1, 0, 0];
    const dy = [0, 0, 1, -1];
    let count = 0;
    let queue = [];
    let visited = new Array(Y).fill(0).map(() => new Array(X).fill(0));
    
    queue.push(start);
    while(queue.length) {
        const curr = queue.shift();
        
        if(curr.x === end.x && curr.y === end.y) return visited[curr.y][curr.x];
        
        for(let i=0; i<4; i++) {
            let nx = curr.x + dx[i];
            let ny = curr.y + dy[i];
            
            if(0 > nx || nx >= X || 0 > ny || ny >= Y) continue;
            if(visited[ny][nx] || maps[ny].charAt(nx) === 'X') continue;
            
            visited[ny][nx] = visited[curr.y][curr.x] + 1;
            queue.push({x: nx, y: ny});
        }
    }
    
    return -1;
}