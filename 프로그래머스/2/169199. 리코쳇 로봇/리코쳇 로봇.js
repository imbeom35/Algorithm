const solution = (board) => {
    const dy = [1, -1, 0, 0];
    const dx = [0, 0, 1, -1];
    const Y = board.length;
    const X = board[0].length;
    const queue = [];
    let answer = -1;
    let visited = new Array(Y).fill(0).map(() => new Array(X).fill(0));
    
    for(let y=0; y<Y; y++) {
        for(let x=0; x<X; x++) {
            if(board[y][x] == 'R') {
                queue.push({x, y});
                visited[y][x] = 1;
                break;
            }
        }
    }
    
    while(queue.length != 0) {
        let curr = queue.shift();
        
        if(board[curr.y][curr.x] == 'G') {
            answer = visited[curr.y][curr.x] - 1;
            break;
        }
        
        for(let i=0; i<4; i++) {
            let ny = curr.y;
            let nx = curr.x;
            
            while(true) {
                ny += dy[i];
                nx += dx[i];
                
                if(0 > ny || ny >= Y || 0 > nx || nx >= X || board[ny][nx] == 'D') {
                    break;
                }
            }
            
            ny -= dy[i];
            nx -= dx[i];
            
            if(!visited[ny][nx]) {
                queue.push({x:nx, y:ny});
                visited[ny][nx] = visited[curr.y][curr.x] + 1;
            }
        }
    }
    
    return answer;
}