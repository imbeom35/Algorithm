const solution = (board) => {
    let cntO = 0, cntX = 0;
    let scoreO = 0, scoreX = 0;
    let map = new Array(3).fill(0).map(() => new Array(3).fill(0));
    const matchs = [
        [[0, 0], [0, 1], [0, 2]],
        [[1, 0], [1, 1], [1, 2]],
        [[2, 0], [2, 1], [2, 2]],
        [[0, 0], [1, 0], [2, 0]],
        [[0, 1], [1, 1], [2, 1]],
        [[0, 2], [1, 2], [2, 2]],
        [[0, 0], [1, 1], [2, 2]],
        [[0, 2], [1, 1], [2, 0]]
    ];
    
    board.forEach((item, idx) => {
        for(i=0; i<item.length; i++) {
            let curr = item.charAt(i);
            switch(curr) {
                case 'O':
                    cntO++;
                    map[idx][i] = 1;
                    break;
                case 'X':
                    cntX++;
                    map[idx][i] = -1;
                    break;
            }
        }
    });
    
    matchs.forEach((match) => {
        let cal = 0;
        match.forEach((item) => {
            cal += map[item[0]][item[1]];
        });
        if(cal === 3) scoreO++;
        if(cal === -3) scoreX++;
    });
    
    //O의 개수는 X의 개수 보다 1크거나 같아야 한다
    if(![0, 1].includes(cntO - cntX)) return 0;
    
    //O와 X가 모두 승리할 수 없다
    if(0 < scoreO && 0 < scoreX) return 0;
    
    //O가 승리했을 경우
    if(0 < scoreO && cntO !== cntX+1) return 0;
    
    //X가 승리했을 경우
    if(0 < scoreX && cntO !== cntX) return 0;
    
    return 1;
}