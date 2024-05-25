const solution = (land) => {
    let max = 0;
    const n = land.length;
    const m = land[0].length;
    let oil_index = 1;
    const visited = new Array(n).fill().map(_ => new Array(m).fill(0));
    const oilMap = new Map();
    const dx = [-1, 0, 1, 0];
    const dy = [0, 1, 0, -1];
    
    const bfs = (init_x, init_y) => {
        let oil = 0;
        const queue = [{x:init_x, y:init_y}];
        visited[init_x][init_y] = oil_index;
        
        while(queue.length) {
            const curr = queue.shift();
            let x = curr.x;
            let y = curr.y;
            if(land[x][y] === 1) oil++;
            
            for(let i=0; i<4; i++) {
                let nx = x + dx[i];
                let ny = y + dy[i];
                
                if (nx < 0 || nx >=n || ny < 0 || ny >= m || visited[nx][ny]) continue;
                
                if(land[nx][ny] === 1) {
                    visited[nx][ny] = oil_index;
                    queue.push({x: nx, y: ny});
                }
            }
        }
        
        oilMap[oil_index++] = oil;
        return oil;
    }
    
    for(let i=0; i<n; i++) {
        for(let j=0; j<m; j++) {
            if(visited[i][j] === 0 && land[i][j] > 0) bfs(i, j);
        }
    }
    
    for(let i=0; i<m; i++) {
        let sum = 0;
        const set = new Set();
        for(let j=0; j<n; j++) {
            if(visited[j][i] !== 0) set.add(visited[j][i]);
        }
        set.forEach((item) => {
            sum += oilMap[item];
        });
        
        max = sum > max ? sum : max;
    }
    
    return max;
}